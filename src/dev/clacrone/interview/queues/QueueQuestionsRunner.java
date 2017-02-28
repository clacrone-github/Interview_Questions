package dev.clacrone.interview.queues;

public class QueueQuestionsRunner {
	public static void runQueueQuestions() {
		TheQueue theQueue = new TheQueue(10);
		theQueue.priorityInsert("10");
		theQueue.priorityInsert("19");
		theQueue.priorityInsert("15");
		theQueue.priorityInsert("11");
		
		theQueue.displayTheQueue();
		
		theQueue.remove();
		theQueue.remove();
		
		theQueue.displayTheQueue();
	}
}
