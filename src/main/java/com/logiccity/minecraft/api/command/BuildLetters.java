package com.logiccity.minecraft.api.command;

import java.util.HashMap;
import java.util.Map;

import com.logiccity.minecraft.api.impl.BuildBooleanArray;

public class BuildLetters extends BuildBooleanArray {
	private static final Map<Character, boolean[][]> map = new HashMap<Character, boolean[][]>();

	static {
		map.put('A', new boolean[][] { new boolean[] { true, true, true, true, true },
				new boolean[] { true, false, false, false, true }, new boolean[] { true, true, true, true, true },
				new boolean[] { true, false, false, false, true }, new boolean[] { true, false, false, false, true } });

		map.put('B', new boolean[][] { new boolean[] { true, true, true, true, false },
				new boolean[] { true, false, false, false, true }, new boolean[] { true, true, true, true, true },
				new boolean[] { true, false, false, false, true }, new boolean[] { true, true, true, true, false } });

		map.put('C', new boolean[][] { new boolean[] { true, true, true, true, true },
				new boolean[] { true, false, false, false, false }, new boolean[] { true, false, false, false, false },
				new boolean[] { true, false, false, false, false }, new boolean[] { true, true, true, true, true } });
		map.put('D', new boolean[][] { new boolean[] { true, true, true, true, false },
				new boolean[] { true, false, false, false, true }, new boolean[] { true, false, false, false, true },
				new boolean[] { true, false, false, false, true }, new boolean[] { true, true, true, true, false } });

		map.put('E', new boolean[][] { new boolean[] { true, true, true, true, true },
				new boolean[] { true, false, false, false, false }, new boolean[] { true, true, true, true, false },
				new boolean[] { true, false, false, false, false }, new boolean[] { true, true, true, true, true } });
		map.put('F',
				new boolean[][] { new boolean[] { true, true, true, true, true },
						new boolean[] { true, false, false, false, false },
						new boolean[] { true, true, true, false, false },
						new boolean[] { true, false, false, false, true },
						new boolean[] { true, false, false, false, false } });

		map.put('G', new boolean[][] { new boolean[] { true, true, true, true, true },
				new boolean[] { true, false, false, false, false }, new boolean[] { true, false, true, true, true },
				new boolean[] { true, false, false, false, true }, new boolean[] { true, true, true, true, true } });
		map.put('H', new boolean[][] { new boolean[] { true, false, false, false, true },
				new boolean[] { true, false, false, false, true }, new boolean[] { true, true, true, true, true },
				new boolean[] { true, false, false, false, true }, new boolean[] { true, false, false, false, true } });

		map.put('I', new boolean[][] { new boolean[] { true, true, true, true, true },
				new boolean[] { false, false, true, false, false }, new boolean[] { false, false, true, false, false },
				new boolean[] { false, false, true, false, false }, new boolean[] { true, true, true, true, true } });
		map.put('J', new boolean[][] { new boolean[] { true, true, true, true, true },
				new boolean[] { false, false, false, true, false }, new boolean[] { false, false, false, true, false },
				new boolean[] { false, true, false, true, false }, new boolean[] { false, true, true, true, false } });

		map.put('K', new boolean[][] { new boolean[] { true, true, false, true, true },
				new boolean[] { true, true, false, true, false }, new boolean[] { true, true, true, false, false },
				new boolean[] { true, true, false, true, false }, new boolean[] { true, true, false, false, true } });
		map.put('L', new boolean[][] { new boolean[] { true, false, false, false, false },
				new boolean[] { true, false, false, false, false }, new boolean[] { true, false, false, false, false },
				new boolean[] { true, false, false, false, false }, new boolean[] { true, true, true, true, true } });
		map.put('M', new boolean[][] { new boolean[] { true, false, false, false, true },
				new boolean[] { true, true, false, true, true }, new boolean[] { true, false, true, false, true },
				new boolean[] { true, false, false, false, true }, new boolean[] { true, false, false, false, true } });
		map.put('N', new boolean[][] { new boolean[] { true, false, false, false, true },
				new boolean[] { true, true, false, false, true }, new boolean[] { true, false, true, false, true },
				new boolean[] { true, false, false, true, true }, new boolean[] { true, false, false, false, true } });
		map.put('O', new boolean[][] { new boolean[] { true, true, true, true, true },
				new boolean[] { true, false, false, false, true }, new boolean[] { true, false, false, false, true },
				new boolean[] { true, false, false, false, true }, new boolean[] { true, true, true, true, true } });
		map.put('P',
				new boolean[][] { new boolean[] { true, true, true, true, true },
						new boolean[] { true, false, false, false, true },
						new boolean[] { true, true, true, true, true },
						new boolean[] { true, false, false, false, false },
						new boolean[] { true, false, false, false, false } });
		map.put('Q', new boolean[][] { new boolean[] { true, true, true, true, true },
				new boolean[] { true, false, false, false, true }, new boolean[] { true, false, false, false, true },
				new boolean[] { true, false, false, true, true }, new boolean[] { true, true, true, true, true } });
		map.put('R', new boolean[][] { new boolean[] { true, true, true, true, true },
				new boolean[] { true, false, false, false, true }, new boolean[] { true, true, true, true, true },
				new boolean[] { true, false, false, true, false }, new boolean[] { true, false, false, false, true } });
		map.put('S', new boolean[][] { new boolean[] { true, true, true, true, true },
				new boolean[] { true, false, false, false, false }, new boolean[] { true, true, true, true, true },
				new boolean[] { false, false, false, false, true }, new boolean[] { true, true, true, true, true } });
		map.put('T',
				new boolean[][] { new boolean[] { true, true, true, true, true },
						new boolean[] { false, false, true, false, false },
						new boolean[] { false, false, true, false, false },
						new boolean[] { false, false, true, false, false },
						new boolean[] { false, false, true, false, false } });
		map.put('U', new boolean[][] { new boolean[] { true, false, false, false, true },
				new boolean[] { true, false, false, false, true }, new boolean[] { true, false, false, false, true },
				new boolean[] { true, false, false, false, true }, new boolean[] { true, true, true, true, true } });
		map.put('V',
				new boolean[][] { new boolean[] { true, false, false, false, true },
						new boolean[] { true, false, false, false, true },
						new boolean[] { false, true, false, true, false },
						new boolean[] { false, true, false, true, false },
						new boolean[] { false, false, true, false, false } });
		map.put('W', new boolean[][] { new boolean[] { true, false, false, false, true },
				new boolean[] { true, false, false, false, true }, new boolean[] { true, false, true, false, true },
				new boolean[] { true, true, false, true, true }, new boolean[] { true, false, false, false, true } });
		map.put('X', new boolean[][] { new boolean[] { true, false, false, false, true },
				new boolean[] { false, true, false, true, false }, new boolean[] { false, false, true, false, false },
				new boolean[] { false, true, false, true, false }, new boolean[] { true, false, false, false, true } });
		map.put('Y',
				new boolean[][] { new boolean[] { true, false, false, false, true },
						new boolean[] { false, true, false, true, false },
						new boolean[] { false, false, true, false, false },
						new boolean[] { false, false, true, false, false },
						new boolean[] { false, false, true, false, false } });
		map.put('Z', new boolean[][] { new boolean[] { true, true, true, true, true },
				new boolean[] { false, false, false, true, false }, new boolean[] { false, false, true, false, false },
				new boolean[] { false, true, false, false, false }, new boolean[] { true, true, true, true, true } });
		map.put('0', new boolean[][] { new boolean[] { true, true, true, true, true },
				new boolean[] { true, false, false, false, true }, new boolean[] { true, false, false, false, true },
				new boolean[] { true, false, false, false, true }, new boolean[] { true, true, true, true, true } });
		map.put('1', new boolean[][] { new boolean[] { true, true, true, false, false },
				new boolean[] { false, false, true, false, false }, new boolean[] { false, false, true, false, false },
				new boolean[] { false, false, true, false, false }, new boolean[] { true, true, true, true, true } });
		map.put('2', new boolean[][] { new boolean[] { false, true, true, true, false },
				new boolean[] { true, false, false, false, true }, new boolean[] { false, false, false, true, false },
				new boolean[] { false, false, true, false, false }, new boolean[] { true, true, true, true, true } });
		map.put('3', new boolean[][] { new boolean[] { true, true, true, true, true },
				new boolean[] { false, false, false, false, true }, new boolean[] { false, true, true, true, true },
				new boolean[] { false, false, false, false, true }, new boolean[] { true, true, true, true, true } });
		map.put('4',
				new boolean[][] { new boolean[] { true, false, false, false, true },
						new boolean[] { true, false, false, false, true },
						new boolean[] { true, true, true, true, true },
						new boolean[] { false, false, false, false, true },
						new boolean[] { false, false, false, false, true } });
		map.put('5', new boolean[][] { new boolean[] { false, true, true, true, true },
				new boolean[] { true, false, false, false, false }, new boolean[] { true, true, true, true, true },
				new boolean[] { false, false, false, false, true }, new boolean[] { true, true, true, true, true } });
		map.put('6', new boolean[][] { new boolean[] { true, true, true, true, true },
				new boolean[] { true, false, false, false, false }, new boolean[] { true, true, true, true, true },
				new boolean[] { true, false, false, false, true }, new boolean[] { true, true, true, true, true } });
		map.put('7',
				new boolean[][] { new boolean[] { true, true, true, true, true },
						new boolean[] { false, false, false, false, true },
						new boolean[] { false, false, false, true, false },
						new boolean[] { false, false, true, false, false },
						new boolean[] { false, true, false, false, false } });
		map.put('8', new boolean[][] { new boolean[] { true, true, true, true, true },
				new boolean[] { true, false, false, false, true }, new boolean[] { false, true, true, true, false },
				new boolean[] { true, false, false, false, true }, new boolean[] { true, true, true, true, true } });
		map.put('9',
				new boolean[][] { new boolean[] { true, true, true, true, true },
						new boolean[] { true, false, false, false, true },
						new boolean[] { true, true, true, true, true },
						new boolean[] { false, false, false, false, true },
						new boolean[] { false, false, false, false, true } });

	}

	private BuildLetters() {
		super("letters", 1);
	}

	private boolean[][] switchXY(boolean[][] in) {
		boolean[][] out = new boolean[in[0].length][in.length];
		for (int i = 0; i < in[0].length; i++) {
			for (int j = 0; j < in.length; j++) {
				out[i][j] = in[j][i];
			}
		}
		return out;
	}

	@Override
	public void initCmd(String[] args) {
		int cnt = 0;
		String input = args[0].toUpperCase();
		int length = 7 * input.length() - 2;
		maze = new boolean[length][5];
		for (char ch : input.toCharArray()) {
			boolean[][] array = switchXY(map.get(ch));
			for (int i = 0; i < array[0].length; i++) {
				for (int j = 0; j < array.length; j++) {
					maze[i + cnt * 7][j] = array[i][j];
				}
			}
			cnt++;
		}
		startBp = gameInfo.getLivingEntityLocation(null).add(0, 0, 3);
		super.initCmd(args);
	}

}
