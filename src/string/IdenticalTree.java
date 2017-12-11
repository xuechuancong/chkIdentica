package string;

public class IdenticalTree {

    //        A中是否包含B的子树
    public boolean chkIdentical(TreeNode A, TreeNode B) {

        if(A == null && B!= null)
            return false;

        if(B == null)
            return true;

//        如果
        if(A.val == B.val) {
            boolean left = chkIdentical(A.left, B.left);
            boolean right = chkIdentical(A.right, B.right);

            if(left && right)
                return true;
        }

        boolean left = chkIdentical(A.left, B);
        boolean right = chkIdentical(A.right, B);

        return left || right;

    }

}
