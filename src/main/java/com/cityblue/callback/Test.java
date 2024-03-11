package com.cityblue.callback;


public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        CallBack call = new CallBackImpl();
        test.func2(call);

        test.func2(new CallBack() {
            @Override
            public void func1() {
                System.out.println("doing something...");
            }
        });


        test.func2(()->{
            System.out.println("doing something in another way.....");
        });
    }


    public void func2(CallBack callback){
        System.out.println("need callback");
        callback.func1();
    }
}
