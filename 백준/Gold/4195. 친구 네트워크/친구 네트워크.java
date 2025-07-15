import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	static Map<String, Integer> map;
	static List<Integer> size;
	static List<Integer> parent;
	static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int F = Integer.parseInt(br.readLine());
			
			map = new HashMap<>();
			size = new ArrayList<>();
			parent = new ArrayList<>();
			sb = new StringBuilder();
			int count = 0;
			
			for (int i = 0; i < F; i++) {
				st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();
				
				if (!map.containsKey(a)) {
					map.put(a, count);
					parent.add(count++);
					size.add(1);
				}
				
				if (!map.containsKey(b)) {
					map.put(b, count);
					parent.add(count++);
					size.add(1);
				}

				int x = map.get(b);
				int y = map.get(a);
				
				union(x, y);
				sb.append(size.get(find(x))).append('\n');

			}
			System.out.print(sb);
		}
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x != y) {
			parent.set(y, x);
			size.set(x, size.get(x) + size.get(y));
		}
	}
	
	public static int find(int x) {
		if (parent.get(x) == x) {
			return x;
		}
		
		parent.set(x, find(parent.get(x)));
		
		return parent.get(x);
	}
}