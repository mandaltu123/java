package com.tuhin.javapreps.misc.problems;

/**
 * Created by tuhinmandal on 30/07/16.
 */
public class ParentMethodHigherAccessRights {

    private void doSomethingPrivate() {
        System.out.println("doSomethingPrivate");
    }

    protected void doSomethingProtected() {
        System.out.println("doSomethingProtected");
    }

    public void doSomethingPublic() {
        System.out.println("doSomethingPublic");
    }
}

class ChildWhoWillOverrride extends ParentMethodHigherAccessRights {

    private void doSomethingPrivate() {
        System.out.println("child:doSomethingPrivate");
    }

    protected void doSomethingProtected() {
        System.out.println("child:doSomethingProtected");
    }

    public void doSomethingPublic() {
        System.out.println("child:doSomethingPublic");
    }

    public static void main(String args[]) {


        ParentMethodHigherAccessRights parent = new ParentMethodHigherAccessRights();
        ParentMethodHigherAccessRights child = new ChildWhoWillOverrride();
        ChildWhoWillOverrride childReference = new ChildWhoWillOverrride();

        parent.doSomethingProtected();
//        parent.doSomethingPrivate(); :::: this has private rights, is not visible.compilation error
        parent.doSomethingPublic();
        System.out.println("_______________________");

        child.doSomethingProtected();
       // child.doSomethingPrivate();// :::: this has private rights, is not visible.compilation error
        child.doSomethingPublic();

        System.out.println("_______________________");

        childReference.doSomethingProtected();
        childReference.doSomethingPrivate();
        childReference.doSomethingPublic();


    }

}