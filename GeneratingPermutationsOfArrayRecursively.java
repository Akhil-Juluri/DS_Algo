public class Permutation 
{ 
	public static void main(String[] args) 
	{  
    		int arr[] = {1,2,3};
		Permutation permutation = new Permutation(); 
		permutation.permute(arr, 0, arr.length - 1); 
	} 
	private void permute(int arr[], int l, int r) 
	{ 
		if (l == r) {
			for (int i = 0; i < arr.length; i++) {
          			System.out.print(arr[i]+" ");
      			}
      			System.out.println();
    		}
		else
		{
			for (int i = l; i <= r; i++)
			{
				int temp = arr[l];
        			arr[l] = arr[i];
        			arr[i] = temp;
				permute(arr, l+1, r); 
				temp = arr[l];
        			arr[l] = arr[i];
        			arr[i] = temp;
			}
		}
	}
}
