package attendance;

import org.joda.time.DateTime;

public class AttendDateTime {
	DateTime dt=new DateTime();
	public AttendanceBean GenerateDateTime(int empid)
	{
		String date=dt.getDayOfMonth()+"-"+dt.getMonthOfYear()+"-"+dt.getYear();
		
		String time=dt.getHourOfDay()+":"+dt.getMinuteOfHour();
		
		AttendanceBean attend=new AttendanceBean(empid,date,time,"");
		return attend;
		
	}
	

}
