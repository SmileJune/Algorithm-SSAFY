#include <cstdio>
#include <vector>
#include <algorithm>

using namespace std;
typedef long long ll;
typedef pair<int,int> p;
const int M = 1<<19;
int seg[M], N;

void update(int n, int val){
	while(n<=N){
		seg[n]+=val;
		n+=n&-n;
	}
}

int sum(int n){
	int res = 0;
	while(n){
		res+=seg[n];
		n-=n&-n;
	}
	return res;
}

int main(void){
	scanf("%d ",&N);
	vector<p> v;
	for(int i=0; i<N; i++){
		int n; scanf("%d ",&n);
		v.push_back({n,i+1});
		update(i+1,1);
	}
	sort(v.begin(),v.end());
	ll ans = 0;
	while(v.size()){
		int idx = v.back().second;
		v.pop_back();
		ans+=sum(N)-sum(idx);
		update(idx,-1);
	}
	printf("%lld",ans);
	return 0;
}
