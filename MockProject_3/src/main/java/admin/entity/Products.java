package admin.entity;
// Generated 20:03:11, 16 thg 4, 2024 by Hibernate Tools 5.6.15.Final

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Products generated by hbm2java
 */
public class Products {

	 private int pid;
	    private String productName;
	    private String image;
	    private String description;
	    private boolean status;
	    private int sid;
	    private int cid;
	    
		public Products() {
		}
		public Products(int pid, String productName, String image, String description, boolean status, int sid,
				int cid) {
			this.pid = pid;
			this.productName = productName;
			this.image = image;
			this.description = description;
			this.status = status;
			this.sid = sid;
			this.cid = cid;
		}
		public int getPid() {
			return pid;
		}
		public void setPid(int pid) {
			this.pid = pid;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public boolean isStatus() {
			return status;
		}
		public void setStatus(boolean status) {
			this.status = status;
		}
		public int getSid() {
			return sid;
		}
		public void setSid(int sid) {
			this.sid = sid;
		}
		public int getCid() {
			return cid;
		}
		public void setCid(int cid) {
			this.cid = cid;
		}
	

}
