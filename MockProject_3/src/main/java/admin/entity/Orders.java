package admin.entity;
// Generated 20:03:11, 16 thg 4, 2024 by Hibernate Tools 5.6.15.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Orders generated by hbm2java
 */
public class Orders  {

	 private int oid;
	    private int uid;
	    private Date createDate;
	    private int status;
		public Orders() {
			// TODO Auto-generated constructor stub
		}
		public Orders(int oid, int uid, Date createDate, int status) {
			super();
			this.oid = oid;
			this.uid = uid;
			this.createDate = createDate;
			this.status = status;
		}
		public int getOid() {
			return oid;
		}
		public void setOid(int oid) {
			this.oid = oid;
		}
		public int getUid() {
			return uid;
		}
		public void setUid(int uid) {
			this.uid = uid;
		}
		public Date getCreateDate() {
			return createDate;
		}
		public void setCreateDate(Date createDate) {
			this.createDate = createDate;
		}
		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
		}


}
