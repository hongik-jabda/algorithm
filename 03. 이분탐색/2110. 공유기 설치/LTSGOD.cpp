#include <iostream>
#include <map>
#include <algorithm>

using namespace std;

long long int arr[200001];
int N, C;

bool check(int minimum) {
    int count = 1;
    long long int tmp = arr[0];
    for (int i = 1; i < N; i++) {

        if (arr[i] - tmp >= minimum) {

            // cout << arr[i] << " ";
            count++;
            tmp = arr[i];
        }
    }
    // cout << "\n";

    if (count >= C) {
        return true;
    } else {
        return false;
    }
}

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    long long int max_v = -1;

    cin >> N >> C;

    for (int i = 0; i < N; i++) {

        cin >> arr[i];
        if (arr[i] > max_v) {
            max_v = arr[i];
        }
    }

    sort(arr, arr+N);

    // for (int i = 0; i < N; i++) {
    //     cout << arr[i] << " ";
    // }

    long long int start = 0;
    long long int end = max_v + 1;

    while (start + 1 < end) {
        
        long long int mid = (start + end) / 2;

        // cout << start << " " << mid << " " << end << endl;

        if (check(mid)) {
            start = mid;
        } else {
            end = mid;
        }
    }

    cout << start;


    return 0;
}
