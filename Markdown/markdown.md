# Markdown 문법

## 목차
1. [Header](#1-header)      7. [Link](#7-link)
2. [BlockQuote](#2-blockquote)    8. [Image](#8-image)
3. [Emphasis](#3-emphasis)     9. [Table](#9-table)
4. [List](#4-list)
5. [Codeblock](#5-codeblock)
6. [Horizontal Rule](#6-horizontal-rule)

## 마크다운(Markdown)이란?
* 마크다운 (Markdown)은 마크업 언어의 일종으로, 존 그루버(John Gruber)와 아론 스워츠(Aaron Swartz)가 만들었다. HTML 문서보다 읽기, 쓰기가 쉬운 문서 양식이 특징이며, 확장자는 .md이다.

<br>

## 1. Header

`<h1>` 부터 `<h6>` 까지 표현이 가능합니다
```markdown
# 제목1
## 제목2
### 제목3
#### 제목4
##### 제목5
###### 제목6
```
`<h1>` 과 `<h2>` 는 아래와 같이 표현이 가능합니다

```markdown
제목 1
======

제목 2
------
```
<br>

## 2. BlockQuote
`>` 를 사용하여 인용문을 사용할 수 있습니다

```markdown
> first blockquote
>> second blockquote
>>> third blockquote
```
> first blockquote
>> second blockquote
>>> third blockquote

<br>


## 3. Emphasis
```markdown
*이탤릭체*
_이탤릭체_
**굵은글씨**
__굵은글씨__
~~취소선~~
<u>밑줄</u>
```
+ *이탤릭체*
+ **굵은글씨**
+ ~~취소선~~
+ <u>밑줄</u>

<br>

## 4. List
`*`, `+`, `-` 를 통해 순서 없는 목록을 사용합니다
```markdown
1. 첫번째
  - 순서 X
2. 두번째
  + 순서 X
3. 세번째
  * 순서 X

* asterisk
    + plus
        - hyphen
```

1. 첫번째
    - 순서 X
2. 두번째
    + 순서 X
3. 세번째
    * 순서 X

* asterisk  
    + plus
        - hyphen
<br>
<br>

## 5. Codeblock

` (Grave) 키로 코드를 강조할 수 있습니다.

`System.out.println();` 과 같이 사용 가능합니다

`를 세번 입력하면 block 코드 사용이 가능하고, 코드에 사용하는 언어를 적어주면 그 언어에 맞게 문법을 강조해 줍니다.

```java
```java
public static void main(String[] args) {

}
```                                       > 이렇게 사용
```
```java
public static void main(String[] args) {

}
```
<br>

## 6. Horizontal Rule
아래의 각각의 기호들은 모두 수평선을 만들어 줍니다.

각 기호를 3개 이상 입력해야 합니다.
```markdown
---
***
___
```
* 예시
---
***
___
<br>

## 7. Link
대괄호 안에 원하는 단어나 문장, 소괄호 안에 링크를 작성하면 링크를 클릭할 수 있게 만들어줍니다. <br>
* URL 직접 입력
    ```markdown
    <https://github.com/>
    ```
    + <https://github.com/>

<br>

* 텍스트에 링크 넣기
    ```markdown
    [Github 홈페이지](https://github.com/)를 클릭하세요.
    ```
    + [Github 홈페이지](https://github.com/)

<br>

* 삽입한 링크에 설명 추가하기
    ```markdown
    [Github 홈페이지](https://github.com/ "GITHUB")
    ```
    + [Github 홈페이지](https://github.com/ "GITHUB")

<br>

* 참조 링크

    `[참조링크 텍스트]: 참조링크 URL` 의 형태로 사용하며,
    링크를 삽입하고자 하는 부분에 `[참조링크 텍스트]`를 입력하면
    링크를 삽입할 수 있습니다.
    ```markdown
    [Github][github]
    .....
    [github]: https://github.com/
    ```

<br>

* Markdown 페이지 안에서 이동하기
    + 하이퍼링크 사용과 유사하지만, 링크에 `#`로 지정해줍니다.
    + `(#이동_위치)`를 쓸 때 유의할 점
        - 알파벳은 소문자만 사용 가능합니다.
        - 띄어쓰기는 `-`(hyphen)으로 구분합니다.
    ```
    [Move text](#index-text)
    ```

<br>

## 8. Image
```
![image description](image URL)
```
* 예시


    ![포메라니안](https://cdn.pixabay.com/photo/2019/10/02/14/36/spitz-4521093_1280.jpg)

<br>

## 9. Table
* : (colon) 으로 좌우 정렬이 가능합니다.
* | (vertical bar) 기호를 통해 표를 만듭니다.

```
| Header | Description |
|---|:---:|
| Cell1 | Cell2 |
| Cell1 | Cell2 |
| Cell1 | Cell2 |
| Cell1 | Cell2 |
```
| Header | Description |
|---|:---:|
| Cell1 | Cell2 |
| Cell1 | Cell2 |
| Cell1 | Cell2 |
| Cell1 | Cell2 |
