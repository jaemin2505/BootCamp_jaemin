package javaFund;

import javax.swing.JOptionPane;

class Game {
	private int cnt = 0, win = 0, lose = 0, draw = 0;
	private String pc = "";
	private String cont = "";
	private String input = "";

	public int getRnd() {
		return (int) (Math.random() * 3) + 1;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt() {
		this.cnt++;
	}

	public int getWin() {
		return win;
	}

	public void setWin() {
		this.win++;
	}

	public int getLose() {
		return lose;
	}

	public void setLose() {
		this.lose++;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw() {
		this.draw++;
	}

	public float getWinRate() {
	    return (float) win / cnt * 100;
	}

	public String getPc() {
		return pc;
	}

	public void setPc() {
		int r = getRnd();
		if (r == 1)
			this.pc = "가위";
		else if (r == 2)
			this.pc = "바위";
		else
			this.pc = "보";
	}

	public String getCont() {
		return cont;
	}

	public void setCont() {
		cont = JOptionPane.showInputDialog("계속 할래요? (y/n)");
		while (!cont.equals("y") && !cont.equals("n")) {
			cont = JOptionPane.showInputDialog("y 또는 n 입력");
		}
	}

	public String getInput() {
		return input;
	}

	public void userInput() {
		input = JOptionPane.showInputDialog("게임을 시작함");

		while (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("가위")
				&& !input.equals("바위") && !input.equals("보")) {
			input = JOptionPane.showInputDialog("올바른 값 입력");
		}

		if (input.equals("1"))
			input = "가위";
		else if (input.equals("2"))
			input = "바위";
		else if (input.equals("3"))
			input = "보";
	}
	
	public void setResult() {
		setCnt();
		if (pc.equals(input)) {
			System.out.println("비김");
			setDraw();
		} else if (pc.equals("가위")) {
			if (input.equals("바위")) {
				System.out.println("당신 승리!");
				setWin();
			} else if (input.equals("보")) {
				System.out.println("컴 승리!");
				setLose();
			}
		} else if (pc.equals("바위")) {
			if (input.equals("가위")) {
				System.out.println("컴 승리!");
				setLose();
			} else if (input.equals("보")) {
				System.out.println("당신 승리!");
				setWin();
			}
		} else if (pc.equals("보")) {
			if (input.equals("가위")) {
				System.out.println("당신 승리!");
				setWin();
			} else if (input.equals("바위")) {
				System.out.println("컴 승리!");
				setLose();
			}
		}
	}
}

public class Gawibawibo2 {
	public static void main(String[] args) {
		Game a = new Game();
		do {
			a.userInput();
			a.setPc();
			System.out.printf("컴 : %s, 당신 : %s\n", a.getPc(), a.getInput());
			a.setResult();
			a.setCont();
		} while (a.getCont().equals("y"));
		System.out.printf("총 전적 : %d, 승 : %d, 패 : %d, 무 : %d, 승률 : %.2f\n", a.getCnt(), a.getWin(), a.getLose(), a.getDraw(), a.getWinRate());
	}

}
