//////////
// USACO UNOFFICIAL SOLUTION CONTEST 2 PROBLEM 3
// BRANDON LIN
// C++
/////////
#include<iostream>
#include<vector>
#include<cstdio>

using namespace std;

int convert(int num,int base){
  return (num / 100) * base * base + ((num - (num / 100) * 100) / 10) * base + num % 10;
}

vector<int> brute(int num1, int num2){
  int x = 10;
  int y = 10;
  vector<int> m;
  while(x <= 15000){
    while(y <= 15000){
      if(convert(num1,x) == convert(num2,y)){
	m.push_back(x); m.push_back(y);
	return m;
      }else if(convert(num1,x) < convert(num2,y)){
	break;
      }
      y += 1;
    }
    x += 1;
  }
  m.push_back(0); m.push_back(0);
  return m;
}

int main(){
  int length;
  freopen("whatbase.in", "r", stdin);
  freopen("whatbase.out", "w", stdout);
  cin >> length;
  vector<int> pair (2,0);
  for(int i = 0; i < length; i++){
    int num1, num2;
    cin >> num1 >> num2;
    pair = brute(num1,num2);
    cout << pair.at(0) << " " << pair.at(1) << "\n";
  }
  return 0;
}
