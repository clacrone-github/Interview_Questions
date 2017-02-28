package dev.clacrone.interview.stacks;

public class StackQuestionsRunner {
	public static void runStackQuestions() {
		TheStack theStack = new TheStack(10);
		theStack.push("10");
		theStack.push("15");
		theStack.peek();
		theStack.pop();
	}
}
