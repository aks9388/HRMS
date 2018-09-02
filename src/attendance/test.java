package attendance;

import org.joda.time.DateTime;

public class test {

	public static void main(String[] args) {
		AttendanceBean attend=null;
		AttendDateTime dt=new AttendDateTime();
		attend=dt.GenerateDateTime(1001);
		System.out.println(attend.getEmpid()+" "+attend.getDate()+" "+attend.getTimein()+" "+attend.getTimeout());

	}

}
