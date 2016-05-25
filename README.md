# HeaderFooterRecyclerView
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-HeaderFooterRecyclerView-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/3286)

![Screenshots](https://raw.github.com/kk-java/HeaderFooterRecyclerView/master/art/screenshot.png)


Getting started
---

This library is published on jCenter. Just add these lines to `build.gradle`.

```groovy
dependencies {
    compile 'com.liucanwen.app:headerfooterrecyclerview:1.0.0'
}
```

Usage
---
```java
private void refreshRecyclerView(int column) {

    MyAdapter myAdapter = new MyAdapter(MainActivity.this);
    HeaderAndFooterRecyclerViewAdapter adapter = new HeaderAndFooterRecyclerViewAdapter(myAdapter);
    recyclerView.setAdapter(adapter);

    ExStaggeredGridLayoutManager staggeredGridLayoutManager = new ExStaggeredGridLayoutManager(column, StaggeredGridLayoutManager.VERTICAL);
    staggeredGridLayoutManager.setSpanSizeLookup(new HeaderSpanSizeLookup((HeaderAndFooterRecyclerViewAdapter) recyclerView.getAdapter(), staggeredGridLayoutManager.getSpanCount()));
    recyclerView.setLayoutManager(staggeredGridLayoutManager);

    View headerView = LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_header, null);
    View footerView = LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_footer, null);

    RecyclerViewUtils.setHeaderView(recyclerView, headerView);
    RecyclerViewUtils.setFooterView(recyclerView, footerView);
}
```

License
--------

    Copyright 2016 liucanwen.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and