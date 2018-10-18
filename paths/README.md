# Paths

## Introduction

In this project, you will search paths produced by an API such as Google Maps.

This API provides **possible paths from origin to destination**,
for example, all the possible ways to go to Paris from Marseille with all intermediate cities.

We suppose the API produce **only valid paths**, no need to implement any validation on the paths.


## Use Cases

You are suggested to use [Scala test](http://www.scalatest.org/) to write your test cases.

Here is a suggested, step-by-step approach to implement all features :

### Compute the length of a segment

The length is the euclidean distance between origin and destination `sqrt[(x1 - x2)² + (y1 - y2)²]`.

Tests :

* The length of a trivial segment `Point(x, y), Point(x, y)` is 0
* The length of a vertical segment `Point(x, y1), Point(x, y2)` is abs(y1 - y2)
* The length of a general segment `Point(x1, y1), Point(x2, y2)`

Note : you can assume in the next steps that the segments you will receive as arguments will be non trivial.

### Compute the length of a path

The length of a path is the sum of its segments lengths.
An empty path has a length equal to 0.

Tests :

* The length of an empty path
* The length of a path containing a single segment
* The length of a path containing at least two segments

### Find the shortest path in a list of paths

As the shortest path may not be defined (if the list is empty),
this function returns an Option.

Tests :

* The shortest path of an empty list of paths
* The shortest path of a list of paths containing only empty paths
* The shortest path of a list of paths containing a single path
* The shortest path of a list of paths containing at least two paths

### Enumerate all stops in a path

Stops in a path are all intermediate points of a path.
They represent possible places where a driver could stop to pickup or deposit someone.

Tests :

* All stops of an empty path
* All stops of a path containing a single segment
* All stops of a path containing at least two segments

### Filter paths keeping only those which include a stop

Given a list of paths and a point, produce the list of paths which have this intermediate stop.

Tests :

* Filter an empty list of paths
* Filter a list of paths containing paths which not include the stop
* Filter a list of paths containing at least one path which include the stop

### Filter paths keeping only those which include a given list of points

Given a list of paths and a list of points,
return the list of paths which stops at all of these points.

Tests :

* Filter an empty list of paths
* Filter a list of paths which not stop at the full list of points
* Filter a list of paths containing at least one path which stops at all the points

### Find the best path

Find the shortest path in a list of paths, which stops at a given list of points.
As the shortest path may not exists (if the list is empty), this function returns an Option.

Tests :

* The best path of an empty list of paths
* The best path of a list of paths containing a single path which does not include the full list of points
* The best path of a list of paths containing a single path which includes the list of points
* The best path of a list of paths containing at least two paths which include the list of points

### Find all possible paths

Compute all possible paths between 2 points, given a list of Segments.
The segments of the path must have the correct direction, so be careful not to swap origin and destination.
We suppose that the list of Segments contains at least a path between the two points
(no need to return an Option here).

Hint : use a recursion on the segments and the origin. End the recursion when the origin is the same as destination, and return an empty Path (no segments).

Hint : check that your method works with segments making a cycle. When doing recursion on the segment, you can eliminate all segment starting from your current origin to avoid those cycles.

Tests :

Assuming you search the possible paths between `Point(x1,y1)` and `Point(x2,y2)`

* The possible paths when the segments are empty
* The possible paths with the list `[Segment(Point(x1, y1), Point(x2, y2))]`
* The possible paths with segments without cycle
* The possible paths with segments with cycle. Ex : test with this configuration when all segments are created both ways.



### Wrap-up

Find the best path given :
* a list of segments
* an origin
* a destination
* a list of stops to pass by

### Possible design

![](https://g.gravizo.com/g?/**%20@opt%20all%20*/class%20Point%20{%20%20public%20int%20x;%20%20public%20int%20y;}/**%20@opt%20all%20*/class%20Segment%20{%20%20public%20Point%20origin;%20%20public%20Point%20destination;%20%20public%20double%20distance%28%29;}/**%20@opt%20all%20*/class%20Path%20{%20%20public%20List%20segments;%20%20public%20double%20distance%28%29;%20%20public%20List%20stops;}/**%20@opt%20all%20*/class%20PathList%20{%20%20public%20List%20paths;%20%20public%20Path%20shortestPath%28%29;})


## Grading

This project must be done with pure functional style.
This means that you have to program without mutable variables, re-assignments, while loops, and other imperative control structures (return, break ...).

For each question, you get points based on :

* The implementation following rules above (about 75%)
* Writing tests associated to this implementation as described in each question (about 25%)

Questions | Points :

* Compute the length of a segment | 1
* Compute the length of a path | 2
* Find the shortest path in a list of paths | 2
* Enumerate all stops in a path | 2
* Filter paths keeping only those which include a stop | 2
* Filter paths keeping only those which include a given list of stops | 3
* Find the best path | 3
* Find all possible paths | 5
* Wrap-up | 2
