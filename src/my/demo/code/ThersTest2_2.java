package my.demo.code;
class Resource
{
	String name;
	String sex;
	//定义标记，
	boolean flag = false;

}
//赋值线程任务
class Input implements Runnable
{
	private Resource r;
//	private Object obj = new Object();
	Input(Resource r)//任务一初始化就必须有要处理的资源。
	{
		this.r = r;
	}
	public void run()
	{
		int x = 0;
		while(true)
		{
			synchronized(r)
			{
				if(r.flag)
					try{r.wait();}catch(InterruptedException e){}
				if(x==0)
				{
					r.name = "张飞";
					r.sex = "男";
				}
				else
				{
					r.name = "rose";
					r.sex = "女女女女";
				}

				r.flag = true;
				r.notify();
			}
			x = (x+1)%2;//实现切换。
		}
	}
}
//获取值线程任务
class Out implements Runnable
{
	private Resource r ;

	Out(Resource r)
	{
		this.r = r;
	}
	public void run()
	{
		while(true)
		{
			synchronized(r)
			{
				if(!r.flag)
					try{r.wait();}catch(InterruptedException e){}
				System.out.println(r.name+"....."+r.sex);
				r.flag = false;
				r.notify();
			}
		}
	}
}

class ThreadTest2_2
{
	public static void main(String[] args)
	{
		Resource r = new Resource();
		Input in = new Input(r);
		Out out = new Out(r);
		Thread t1 = new Thread(in);
		Thread t2 = new Thread(out);
		t1.start();
		t2.start();

	}
}