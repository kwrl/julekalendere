package adventofcode.task1;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.StringTokenizer;

import adventofcode.util.Vec2;

public class Task1 {
	public final static String INSTRUCTIONS = "L3, R1, L4, L1, L2, R4, L3, L3, R2, R3, L5, R1, R3, L4, L1, L2, R2, R1, L4, L4, R2, L5, R3, R2, R1, L1, L2, R2, R2, L1, L1, R2, R1, L3, L5, R4, L3, R3, R3, L5, L190, L4, R4, R51, L4, R5, R5, R2, L1, L3, R1, R4, L3, R1, R3, L5, L4, R2, R5, R2, L1, L5, L1, L1, R78, L3, R2, L3, R5, L2, R2, R4, L1, L4, R1, R185, R3, L4, L1, L1, L3, R4, L4, L1, R5, L5, L1, R5, L1, R2, L5, L2, R4, R3, L2, R3, R1, L3, L5, L4, R3, L2, L4, L5, L4, R1, L1, R5, L2, R4, R2, R3, L1, L1, L4, L3, R4, L3, L5, R2, L5, L1, L1, R2, R3, L5, L3, L2, L1, L4, R4, R4, L2, R3, R1, L2, R1, L2, L2, R3, R3, L1, R4, L5, L3, R4, R4, R1, L2, L5, L3, R1, R4, L2, R5, R4, R2, L5, L3, R4, R1, L1, R5, L3, R1, R5, L2, R1, L5, L2, R2, L2, L3, R3, R3, R1";
	
	public static void main(String[] args) {
		StringTokenizer tk = new StringTokenizer(INSTRUCTIONS);
		Walker walker = new Walker();
		
		while (tk.hasMoreTokens()) {
			String token = tk.nextToken().replace(",", "");

			if (token.charAt(0) == 'L') {
				walker.turnLeft();
			} else {
				walker.turnRight();
			}

			int length = Integer.parseInt(token.substring(1, token.length()));
			for(int i = 0; i < length; i++) {
				walker.move(1);
			}
		}
	
		Optional<Vec2> firstDuplicateOpt = getFirstDuplicate(walker.getPath());
		if(firstDuplicateOpt.isPresent()) {
			System.out.println(firstDuplicateOpt.get());
			System.out.println(Math.abs(firstDuplicateOpt.get().getX())+Math.abs(firstDuplicateOpt.get().getY()));
		}
	}
	
	public static Optional<Vec2> getFirstDuplicate(List<Vec2> path) {
		Set<Vec2> visited = new HashSet<>();
		for(Vec2 pos : path) {
			if(visited.contains(pos)) {
				return Optional.ofNullable(pos);
			}
			visited.add(pos);
		}
		return Optional.ofNullable(null);
	}
}
