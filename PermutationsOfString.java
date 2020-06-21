class Ideone
{
	public static TreeSet<String> findPermutations (String str) {
        ArrayList<String> res = new ArrayList<String>();
        ArrayList<String> temp = new ArrayList<String>();
        StringBuilder bs = new StringBuilder();
        res.add(str.charAt(0)+"");
        for(int i = 1; i < str.length(); i++) {
            for(int j = 0; j < res.size(); j++) {
                String s = res.get(j);
                for(int k = 0; k < s.length()+1; k++) {
                    for(int l = 0; l < s.length(); l++) {
                        if (k == l)
                            bs.append(str.charAt(i));
                        bs.append(s.charAt(l));
                    }
                    if (k == s.length()) {
                        bs.append(str.charAt(i));
                    }
                    //System.out.println(bs.toString());
                    temp.add(bs.toString());
                    bs.setLength(0);
                }
            }
            res.clear();
            res.addAll(temp);
            temp.clear();
        }
        TreeSet<String> ts = new TreeSet<String>();
        for(int i = 0; i < res.size(); i++) {
            ts.add(res.get(i));
        }
        return ts;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		TreeSet<String> ts = new TreeSet<String>();
		ts = findPermutations(str);
		System.out.println(ts+"  "+ts.size());
	}
}
