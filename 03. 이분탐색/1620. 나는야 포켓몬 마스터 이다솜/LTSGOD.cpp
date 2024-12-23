#include <iostream>
#include <map>

using namespace std;
string num_book[100001];
map<string, int> name_book;

int main() {
    
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int N, M;
    cin >> N >> M;

    for (int i = 1; i <= N; i++) {
        cin >> num_book[i];
        name_book.insert(make_pair(num_book[i], i));
    }

    for (int i = 0; i < M; i++) {
        string tmp;
        
        cin >> tmp;

        if (tmp[0] >= '0' && tmp[0] <= '9') {
            cout << num_book[stoi(tmp)] << "\n";
        } else {
            cout << name_book[tmp] << "\n";
        }
    }


    return 0;
}
