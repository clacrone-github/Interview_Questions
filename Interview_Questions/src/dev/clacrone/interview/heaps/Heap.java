package dev.clacrone.interview.heaps;

public class Heap {
	public int Left(int index) {
		return ((2 * index) + 1);
	}
	
	public int Right(int index) {
		return ((2 * index) + 2);
	}
	
	public int Parent(int index) {
		return ((index - 1) / 2);
	}
	
	public void Swap(int x, int y) {
		int temp = x;
		x = y;
		y = temp;
	}
	
	public int SwapWithChild(int index, int[] heap, int size) {
		int left = Left(index);
		int right = Right(index);
		int largest = index;
		
		if (right < size) {
			if (heap[left] < heap[right]) {
				largest = right;
			} else {
				largest = left;
			}
			
			if (heap[index] > heap[largest]) {
				largest = index;
			}
		} else if (left < size) {
			if (heap[index] < heap[left]) {
				largest = left;
			}
		}
		
		if (heap[index] < heap[largest]) {
			Swap(heap[index], heap[largest]);
		}
		
		return largest;
	}
	
	public void RemoveRoot(int[] heap, int size) {
		heap[0] = heap[size - 1];
		--size;
		int last = 0;
		int i = SwapWithChild(0, heap, size);
		while (i != last) {
			last = i;
			i = SwapWithChild(i, heap, size);
		}
	}
	
	public int SwapWithParent(int i, int[] heap) {
		if (i < 1) {
			return i;
		}
		
		int parent = Parent(i);
		if (heap[i] > heap[parent]) {
			Swap(heap[i], heap[parent]);
			return parent;
		} else {
			return i;
		}
	}
	
	public void AddElement(int newEntry, int[] heap, int size) {
		heap[size] = newEntry;
		int last = size;
		int i  = SwapWithParent(last, heap);
		while (last != i) {
			last = i;
			i = SwapWithParent(i, heap);
		}
	}
	
	public void OutputHeap(int[] heap, int size) {
		int depth = 0;
		int copy = size;
		while (copy > 0) {
			copy >>= 1;
			++depth;
		}
		
		int maxWidth = (1 << depth);
		int charWidth = 4*maxWidth;
		int entry = 0;
		
		for (int i = 0; i < depth; ++i) {
			int powerOf2 = (1 << i);
			for (int j = 0; j < powerOf2; ++j) {
				int spacesBefore = ((charWidth/(1 << (i + 1))) - 1);
				// Spaces before number
				for (int k = 0; k < spacesBefore; ++k) {
					System.out.print(" ");
				}
				// Output an extra space if the number is less than 10
				if (heap[entry] < 10) {
					System.out.print(" ");
				}
				// Output the entry and spaces after it
				System.out.print(heap[entry]);
				
				++entry;
				
				if (entry >= size) {
					System.out.println();
					return;
				}
				for (int k = 0; k < spacesBefore; ++k) {
					System.out.print(" ");
				}
			}
			System.out.println();
			System.out.println();
		}
	}
	
	public void OutputArray(int[] heap, int size) {
		for (int i = 0; i < size; ++i) {
			System.out.print(heap[i] + " ");
		}
		System.out.println();
	}
}
