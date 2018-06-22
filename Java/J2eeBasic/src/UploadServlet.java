import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		String filename = null;
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			//Set the max file to be 1MB
			factory.setSizeThreshold(1024 * 1024);
			
			List items = upload.parseRequest(request);
			
			Iterator iter = items.iterator();
			System.out.println(items);
			while(iter.hasNext()) {
				FileItem item = (FileItem)iter.next();
				if (!item.isFormField()) {
					
					filename = System.currentTimeMillis() + ".jpg";//Name based on time prevent duplicate name
					String photoFolder = request.getServletContext().getRealPath("uploaded");//Get web folder
					
					File f = new File(photoFolder, filename);//Copy file position
					f.getParentFile().mkdirs();
					
					InputStream is = item.getInputStream();
					
					//Copy File
					FileOutputStream fos = new FileOutputStream(f);
					byte[] bytes = new byte[1024 * 1024];
					int length = 0;
					if (-1 != (length = is.read(bytes))) {
						fos.write(bytes, 0, length);
					}
					fos.close();
				}else {
					System.out.println(item.getFieldName());
					String value = item.getString();
					value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
					System.out.println(value);
				}
			}
			String html = "<img width='200' height='150' src='uploaded/%s' />";
			response.setContentType("text/html");
			response.getWriter().format(html, filename);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
