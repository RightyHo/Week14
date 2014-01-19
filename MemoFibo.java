public class MemoFibo {
	private static int[] precalculated = null;
	
	public static void main(String[] args){
		MemoFibo mf = new MemoFibo();
		mf.launch();
	}
	public void launch(){
/*		System.out.println("Starting calculation of F(40) the old fashioned way...");
		long startTime = System.currentTimeMillis();
		System.out.println("F(40) = " + String.valueOf(fib(40)));
		long finishTime = System.currentTimeMillis();		
		System.out.println("This operation took " + String.valueOf(finishTime - startTime) + "ms.");

		System.out.println("Starting calculation of F(40) using Memoization...");
		startTime = System.currentTimeMillis();
		System.out.println("F(40) = " + String.valueOf(memoFibo(40)));
		finishTime = System.currentTimeMillis();		
		System.out.println("Using Memoization this operation took " + String.valueOf(finishTime - startTime) + "ms.");		
*/		
		System.out.println("Starting calculation of F(45) the old fashioned way...");
		long startTime = System.currentTimeMillis();
		System.out.println("F(45) = " + String.valueOf(fib(45)));
		long finishTime = System.currentTimeMillis();		
		System.out.println("This operation took " + String.valueOf(finishTime - startTime) + "ms.");

		System.out.println("Starting calculation of F(45) using Memoization...");
		startTime = System.currentTimeMillis();
		System.out.println("F(45) = " + String.valueOf(memoFibo(45)));
		finishTime = System.currentTimeMillis();		
		System.out.println("Using Memoization this operation took " + String.valueOf(finishTime - startTime) + "ms.");	
	}
	public static int fib(int n){
		if((n==1)||(n==2)){
			return 1;
		} else {
			int result = fib(n-1) + fib(n-2);
			return result;
		}
	}
	public static int memoFibo(int n){
		if(precalculated == null){
			//initialise an empty array of length n
			precalculated = new int[n];
			for(int i=0;i<n;i++){
				precalculated[i] = -1;
			}
		}
			//base case
		if((n==1)||(n==2)){
			return 1;
		} else {
			if(precalculated[n-1] != -1){
				return precalculated[n-1];
			} else {
				int result = memoFibo(n-1) + memoFibo(n-2);
				precalculated[n-1] = result;
				return result;
			}
		}
	}
}