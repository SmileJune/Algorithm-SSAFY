#include <cstdio>
#include <algorithm>
#include <vector>

using namespace std;
typedef pair<int,int> p;

int main(void){
	int N; scanf("%d ",&N);
	vector<p> v;
	for(int i=0; i<N; i++){
		int a,b; scanf("%d %d ",&a,&b);
		v.push_back({a,b});
	}
	sort(v.begin(),v.end());
	vector<int> ans;
	for(auto n : v){
		int idx = lower_bound(ans.begin(),ans.end(),n.second)-ans.begin();
		if(idx==ans.size())ans.push_back(n.second);
		else ans[idx]=n.second;
	}
	printf("%ld",v.size()-ans.size());
	return 0;
}
