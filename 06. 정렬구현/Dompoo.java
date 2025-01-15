public class Dompoo {
	
	public static void main(String[] args) {
		int[] arr = new int[]{2, 11, 12, 6, 1, 8, 3, 13, 15, 5, 9, 14, 7, 10, 4};
		
		int[] result1 = BubbleSort.sort(Arrays.copyOf(arr, arr.length));
		System.out.println("버블 정렬 결과 : " + Arrays.toString(result1));
		
		int[] result2 = MergeSort.sort(Arrays.copyOf(arr, arr.length), 0, arr.length - 1);
		System.out.println("병합 정렬 결과 : " + Arrays.toString(result2));
		
		int[] result3 = QuickSort.sort(Arrays.copyOf(arr, arr.length), 0, arr.length - 1);
		System.out.println("퀵 정렬 결과 : " + Arrays.toString(result3));
		
		int[] result4 = HeapSort.heapSort(Arrays.copyOf(arr, arr.length));
		System.out.println("힙 정렬 결과 : " + Arrays.toString(result4));
	}
	
	public static class BubbleSort {
		
		/**
		 * 버블 정렬
		 * @param arr 정렬하고자 하는 배열
		 * @return 정렬된 배열
		 */
		public static int[] sort(int[] arr) {
			int insertIndex = arr.length - 1;
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < insertIndex; j++) {
					if (arr[j] > arr[j + 1]) swap(arr, j, j + 1);
				}
				insertIndex--;
			}
			return arr;
		}
	}
	
	public static class MergeSort {
		
		/**
		 * 병합 정렬
		 * @param arr 정렬하고자 하는 배열
		 * @param left 정렬을 시작하는 인덱스
		 * @param right 정렬을 종료하는 인덱스
		 * @return 정렬된 배열
		 */
		public static int[] sort(int[] arr, int left, int right) {
			if (left < right) {
				int mid = (left + right) / 2;
				sort(arr, left, mid);
				sort(arr, mid + 1, right);
				merge(arr, left, mid, right);
			}
			return arr;
		}
		
		private static void merge(int[] arr, int left, int mid, int right) {
			// 좌우 배열 초기화
			int leftSize = mid - left + 1;
			int rightSize = right - mid;
			int[] leftArr = new int[leftSize];
			int[] rightArr = new int[rightSize];
			for (int i = 0; i < leftSize; i++) {
				leftArr[i] = arr[left + i];
			}
			for (int i = 0; i < rightSize; i++) {
				rightArr[i] = arr[mid + 1 + i];
			}
			
			// 좌우 배열 병합
			int leftIndex = 0;
			int rightIndex = 0;
			int insertIndex = left;
			while (leftIndex < leftSize && rightIndex < rightSize) {
				if (leftArr[leftIndex] <= rightArr[rightIndex]) {
					arr[insertIndex++] = leftArr[leftIndex++];
				} else {
					arr[insertIndex++] = rightArr[rightIndex++];
				}
			}
			while (leftIndex < leftSize) {
				arr[insertIndex++] = leftArr[leftIndex++];
			}
			while (rightIndex < rightSize) {
				arr[insertIndex++] = rightArr[rightIndex++];
			}
		}
	}
	
	public static class QuickSort {
		
		/**
		 * 퀵 정렬
		 * @param arr 정렬하고자 하는 배열
		 * @param left 정렬을 시작하는 인덱스
		 * @param right 정렬을 종료하는 인덱스
		 * @return 정렬된 배열
		 */
		public static int[] sort(int[] arr, int left, int right) {
			if (left < right) {
				int pivotIndex = partitionAndGetPivotIndex(arr, left, right);
				sort(arr, left, pivotIndex - 1);
				sort(arr, pivotIndex + 1, right);
			}
			return arr;
		}
		
		private static int partitionAndGetPivotIndex(int[] arr, int left, int right) {
			int pivot = arr[left];
			int leftIndex = left + 1;
			int rightIndex = right;
			
			while(leftIndex <= rightIndex) {
				while(leftIndex <= right && arr[leftIndex] < pivot) {
					leftIndex++;
				}
				while(rightIndex >= left && arr[rightIndex] > pivot) {
					rightIndex--;
				}
				if (leftIndex < rightIndex) {
					swap(arr, leftIndex, rightIndex);
				}
			}
			
			swap(arr, left, rightIndex);
			
			return rightIndex;
		}
	}
	
	public static class HeapSort {
		
		/**
		 * 힙 정렬
		 * @param arr 정렬하고자 하는 배열
		 * @return 정렬된 배열
		 */
		public static int[] heapSort(int[] arr) {
			int arrSize = arr.length;
			
			// 모든 부모 노드에 대하여 최대힙으로 만들기 -> 결과적으로 전체가 최대힙이 된다.
			for (int currentIndex = arrSize / 2 - 1; currentIndex >= 0; currentIndex--) {
				buildMaxHeap(arr, arrSize, currentIndex);
			}
			
			// 힙에서 요소를 하나씩 꺼내어 정렬
			for (int sortedIndex = arrSize - 1; sortedIndex >= 0; sortedIndex--) {
				// 현재 루트(최대값)와 마지막 요소 교환
				swap(arr, 0, sortedIndex);
				
				// 줄어든 힙 크기에 대해 힙 구조 재정렬
				buildMaxHeap(arr, sortedIndex, 0);
			}
			
			return arr;
		}
		
		private static void buildMaxHeap(int[] arr, int heapSize, int currentIndex) {
			int largestIndex = currentIndex;
			int leftChildIndex = 2 * currentIndex + 1;
			int rightChildIndex = 2 * currentIndex + 2;
			
			// 왼쪽 자식이 루트보다 크면 가장 큰 값 업데이트
			if (leftChildIndex < heapSize && arr[leftChildIndex] > arr[largestIndex]) {
				largestIndex = leftChildIndex;
			}
			
			// 오른쪽 자식이 가장 큰 값보다 크면 가장 큰 값 업데이트
			if (rightChildIndex < heapSize && arr[rightChildIndex] > arr[largestIndex]) {
				largestIndex = rightChildIndex;
			}
			
			// 업데이트가 되었다면 교환
			if (largestIndex != currentIndex) {
				swap(arr, currentIndex, largestIndex);
				
				// 교환된 하위 트리에 대해 힙 구조 재정렬
				buildMaxHeap(arr, heapSize, largestIndex);
			}
		}
	}
	
	public static void swap(int[] arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
}
