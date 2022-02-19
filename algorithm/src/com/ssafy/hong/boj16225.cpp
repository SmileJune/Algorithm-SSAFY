#include <cstdio>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;
const int MAX=200001;
typedef pair<int,int> p;
p a[MAX];
int main(void){
	int N; scanf("%d ",&N);
	for(int i=0; i<N; i++)scanf("%d ",&a[i].second);
	for(int i=0; i<N; i++)scanf("%d ",&a[i].first);

	sort(a,a+N);
	long long ans = a[0].second;
	priority_queue<int,vector<int>> pq;
	for(int i=1; i<N-1; i+=2){
		pq.push(a[i].second);
		pq.push(a[i+1].second);
		ans+=pq.top();
		pq.pop();
	}
	printf("%lld",ans);
	return 0;
}
