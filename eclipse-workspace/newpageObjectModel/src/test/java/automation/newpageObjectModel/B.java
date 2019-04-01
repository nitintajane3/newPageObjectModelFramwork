package automation.newpageObjectModel;

public class B implements A
{

	@Override
	public void test1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void test2() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args)
	{
		A obj = new B();
		obj.test1();
		obj.test2();
		
		C.reader = new B();
		
		C.reader.test1();
		C.reader.test2();
    }
	}
