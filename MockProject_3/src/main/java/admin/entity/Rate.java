package admin.entity;
// Generated 20:03:11, 16 thg 4, 2024 by Hibernate Tools 5.6.15.Final

/**
 * Rate generated by hbm2java
 */
public class Rate  {

	 private int pid;
	    private int uid;
	    private int rate;
	    private String description;
	    private int id;
	    
	    
		public Rate(int pid, int uid, int rate, String description, int id) {
			this.pid = pid;
			this.uid = uid;
			this.rate = rate;
			this.description = description;
			this.id = id;
		}
		public Rate() {
			// TODO Auto-generated constructor stub
		}
		public int getPid() {
			return pid;
		}
		public void setPid(int pid) {
			this.pid = pid;
		}
		public int getUid() {
			return uid;
		}
		public void setUid(int uid) {
			this.uid = uid;
		}
		public int getRate() {
			return rate;
		}
		public void setRate(int rate) {
			this.rate = rate;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
	    
	    

}
