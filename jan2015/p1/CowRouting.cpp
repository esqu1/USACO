//////////
// USACO UNOFFICIAL SOLUTION CONTEST 2 PROBLEM 1
// BRANDON LIN
// C++
/////////
#include<iostream>
#include<vector>
#include<cstdio>
#include<algorithm>

using namespace std;
int main(){
  int city1, city2, length;
  freopen("cowroute.in", "r", stdin);
  freopen("cowroute.out", "w", stdout);
  cin >> city1 >> city2 >> length;
  int cost, numCities, min = 1001;
  vector<int> cities(500,1);
  bool value = false;
  for(int i = 0; i < length; i++){
    cin >> cost >> numCities;
    for(int j = 0; j < numCities; j++){
      cin >> cities[j];
    }
    for(int k = 0; k < numCities; k++){
      if(cities[k] == city1){
	value = true;
      }else if(cities[k] == city2 && !value){
	break;
      }else if(cities[k] == city2 && value && cost < min){
	min = cost;
	break;
      }else if(cities[k] == city2 && value && cost >= min){
	break;
      }
    }
    value = false;
  }
  if( min == 1001){
    min = -1;
  }
  cout << min << "\n";
  return 0;
}
