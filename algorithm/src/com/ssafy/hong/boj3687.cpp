#include <cstdio>
#include <cstring>
#include <string>
#include <algorithm>
using namespace std;

char maxV[101];
string dp[101];

string num[8]={"0","0","1","7","4","2","0","8"};

string getMin(string &str, string &dsc){
	if(str.size() != dsc.size()) return str.size()>dsc.size()? dsc : str;
	for(int i=0; i<str.size(); i++)if(str[i]!=dsc[i]) return str[i]>dsc[i]? dsc: str;
	return str;
}

string recur(int match, int idx){
	string &res = dp[match];
	if(match==0)return "";
	if(res.size()>0)return res;
	for(int i=2; i<=7; i++)if(match - i >=0 && match - i != 1 ){
		string temp = "";
		if(i==6){
			if(idx==0)temp+="6";
			else temp+="0";
		}
		else temp+=num[i];
		temp+=recur(match-i,idx+1);
		res=res.size()==0?temp:getMin(res,temp);
	}
	return res;
}
void getMaxValue(int t){
	int idx=1;
	maxV[0]=t%2==0?'1':'7';
	while(idx<t/2){
		maxV[idx++]='1';
	}
	maxV[idx]='\0';
}

void getMinValue(int t){
	string res = recur(t,0);
	printf("%s ",res.c_str());
}

int main(void){
	int N; scanf("%d ",&N);
	while(N--){
		int t; scanf("%d ", &t);
		fill(dp,dp+t+1,"");
		getMinValue(t);
		getMaxValue(t);
		printf("%s\n",maxV);
	}
	return 0;
}
