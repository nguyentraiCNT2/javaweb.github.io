package admin.entity;
// Generated 20:03:11, 16 thg 4, 2024 by Hibernate Tools 5.6.15.Final

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Suppliers generated by hbm2java
 */
public class Suppliers {

	  private int sid;
	    private String name;
		public Suppliers(int sid, String name) {
			super();
			this.name = name;
		}
		public Suppliers() {
			// TODO Auto-generated constructor stub
		}
		public int getSid() {
			return sid;
		}
		public void setSid(int sid) {
			this.sid = sid;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	    
	    
}
