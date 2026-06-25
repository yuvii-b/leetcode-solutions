class Solution {
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        String[] tokens = path.split("/");
        List<String> st = new ArrayList<>();
        for(String token : tokens){
            if(token.equals("..")){
                if(!st.isEmpty()) st.remove(st.size() - 1);
            }else if(!token.equals("") && !token.equals(".")) st.add(token);
        }
        for(String token : st){
            sb.append("/").append(token);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}