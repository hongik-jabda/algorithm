#include <iostream>
#include <vector>
#include <cstdlib>
#include <ctime>
#include <algorithm>

using namespace std;

// 랜덤 숫자 생성 함수
vector<int> get_random_number(int N) {
    vector<int> numbers;
    srand(time(0));  // 시드 초기화
    for (int i = 0; i < N; i++) {
        numbers.push_back(rand() % 1000); // 0~999 범위의 랜덤 숫자
    }
    return numbers;
}

// Heap Sort 구현
void heapify(vector<int>& arr, int n, int i) {
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if (left < n && arr[left] > arr[largest])
        largest = left;

    if (right < n && arr[right] > arr[largest])
        largest = right;

    if (largest != i) {
        swap(arr[i], arr[largest]);
        heapify(arr, n, largest);
    }
}

void heap_sort() {
    vector<int> arr = get_random_number(10);
    int n = arr.size();

    cout << "Heap Sort Before: ";
    for (int num : arr) cout << num << " ";
    cout << endl;

    for (int i = n / 2 - 1; i >= 0; i--)
        heapify(arr, n, i);

    for (int i = n - 1; i > 0; i--) {
        swap(arr[0], arr[i]);
        heapify(arr, i, 0);
    }

    cout << "Heap Sort After: ";
    for (int num : arr) cout << num << " ";
    cout << endl;
}

// Bubble Sort 구현
void bubble_sort() {
    vector<int> arr = get_random_number(10);
    int n = arr.size();

    cout << "Bubble Sort Before: ";
    for (int num : arr) cout << num << " ";
    cout << endl;

    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                swap(arr[j], arr[j + 1]);
            }
        }
    }

    cout << "Bubble Sort After: ";
    for (int num : arr) cout << num << " ";
    cout << endl;
}

// Quick Sort 구현
int partition(vector<int>& arr, int low, int high) {
    int pivot = arr[high]; //가장 오른쪽 원소 피봇 설정
    int i = low - 1; // pivot 보다 작은 maximum 인덱스(pivot 보다 작은 애가 나오면 자리 교체)

    // for문 안 if 안돌 수도
    for (int j = low; j < high; j++) {
        if (arr[j] < pivot) {
            i++;
            swap(arr[i], arr[j]);
        }
    }
    swap(arr[i + 1], arr[high]);
    return i + 1;
}

void quick_sort_recursive(vector<int>& arr, int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high); // pivot index
        quick_sort_recursive(arr, low, pi - 1);
        quick_sort_recursive(arr, pi + 1, high);
    }
}

void quick_sort() {
    vector<int> arr = get_random_number(10);
    int n = arr.size();

    cout << "Quick Sort Before: ";
    for (int num : arr) cout << num << " ";
    cout << endl;

    quick_sort_recursive(arr, 0, n - 1);

    cout << "Quick Sort After: ";
    for (int num : arr) cout << num << " ";
    cout << endl;
}

// Merge Sort 구현
void merge(vector<int>& arr, int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;

    vector<int> L(n1), R(n2); // 왼쪽 오른쪽 부분 배열
    for (int i = 0; i < n1; i++) L[i] = arr[left + i];
    for (int i = 0; i < n2; i++) R[i] = arr[mid + 1 + i];

    int i = 0, j = 0, k = left;

    // 부분배열 비교
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) arr[k++] = L[i++];
        else arr[k++] = R[j++];
    }

    // 남은거 처리
    while (i < n1) arr[k++] = L[i++];
    while (j < n2) arr[k++] = R[j++];
}

void merge_sort_recursive(vector<int>& arr, int left, int right) {
    if (left < right) {
        int mid = left + (right - left) / 2;
        merge_sort_recursive(arr, left, mid);
        merge_sort_recursive(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
}

void merge_sort() {
    vector<int> arr = get_random_number(10);
    int n = arr.size();

    cout << "Merge Sort Before: ";
    for (int num : arr) cout << num << " ";
    cout << endl;

    merge_sort_recursive(arr, 0, n - 1);

    cout << "Merge Sort After: ";
    for (int num : arr) cout << num << " ";
    cout << endl;
}

// 메인 함수
int main() {
    cout << "Performing Heap Sort" << endl;
    heap_sort();
    cout << endl;

    cout << "Performing Bubble Sort" << endl;
    bubble_sort();
    cout << endl;

    cout << "Performing Quick Sort" << endl;
    quick_sort();
    cout << endl;

    cout << "Performing Merge Sort" << endl;
    merge_sort();
    cout << endl;

    return 0;
}
