---
title: 靓仔 v1.0.0
language_tabs:
  - shell: Shell
  - http: HTTP
  - javascript: JavaScript
  - ruby: Ruby
  - python: Python
  - php: PHP
  - java: Java
  - go: Go
toc_footers: []
includes: []
search: true
code_clipboard: true
highlight_theme: darkula
headingLevel: 2
generator: "@tarslib/widdershins v4.0.17"

---

# 靓仔

> v1.0.0

Base URLs:

* <a href="http://127.0.0.1:9090">测试环境: http://127.0.0.1:9090</a>

# 靓仔/用户

## POST 注册

POST /user/register/

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|name|query|string| 是 |none|
|password|query|string| 是 |none|

> 返回示例

> 成功

```json
{
  "": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[JSONObject](#schemajsonobject)|

## POST 登录

POST /user/login/

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|name|query|string| 是 |none|
|password|query|string| 是 |none|

> 返回示例

> 成功

```json
{
  "message": "success",
  "token": "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI1ZDRjMTcwMjhlMDM0MWJjOWRhNzI3NWY3ODZjZWU5YiIsInN1YiI6ImxpYW5nemFpIiwiaXNzIjoi57Gz5Y-UIiwiaWF0IjoxNjg0ODM4MjIwLCJleHAiOjE2ODYwNDc4MjB9.0eziCp87KpqzlzamY5XASU1Eh_Dam5hJ6_39qWxrYeM"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[JSONObject](#schemajsonobject)|

# 靓仔/测试

## GET 测试

GET /test/

> 返回示例

> 成功

```json
null
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|string|

# 靓仔/演唱会

## POST 更新演出

POST /play/update/

> Body 请求参数

```json
{
  "id": 764777,
  "address": "498 Cannon Street",
  "numberOfPeople": 72,
  "cost": 749.16,
  "title": "Prof.",
  "message": "R42k1YATwO",
  "issuer": "PhFebB3pao",
  "time": "2023-03-19T08:17:12.000+00:00"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[Play](#schemaplay)| 否 |none|

> 返回示例

> 成功

```json
{
  "message": "success"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[JSONObject](#schemajsonobject)|

## GET 查询所有演出

GET /play/select/

> 返回示例

> 成功

```json
{
  "message": "success",
  "data": [
    {
      "id": 341241,
      "address": "498 Cannon Street",
      "numberOfPeople": 72,
      "cost": 55.255,
      "title": "Prof.",
      "message": "R42k1YATwO",
      "issuer": "PhFebB3pao",
      "time": "2023-05-23T10:19:54.000+00:00"
    },
    {
      "id": 764777,
      "address": "498 Cannon Street",
      "numberOfPeople": 72,
      "cost": 55.255,
      "title": "Prof.",
      "message": "R42k1YATwO",
      "issuer": "PhFebB3pao",
      "time": "2023-03-19T08:17:12.000+00:00"
    },
    {
      "id": 656955,
      "address": "123",
      "numberOfPeople": 123,
      "cost": 123,
      "title": "123",
      "message": "123",
      "issuer": "123",
      "time": "2023-05-23T10:33:55.000+00:00"
    },
    {
      "id": 165595,
      "address": "498 Cannon Street",
      "numberOfPeople": 72,
      "cost": 55.255,
      "title": "Prof.",
      "message": "R42k1YATwO",
      "issuer": "PhFebB3pao",
      "time": "2023-03-19T08:17:12.000+00:00"
    },
    {
      "id": 653395,
      "address": "498 Cannon Street",
      "numberOfPeople": 72,
      "cost": 55.255,
      "title": "Prof.",
      "message": "R42k1YATwO",
      "issuer": "PhFebB3pao",
      "time": "2023-03-19T08:17:12.000+00:00"
    },
    {
      "id": 20866,
      "address": "498 Cannon Street",
      "numberOfPeople": 72,
      "cost": 55.255,
      "title": "Prof.",
      "message": "R42k1YATwO",
      "issuer": "PhFebB3pao",
      "time": "2023-03-19T08:17:12.000+00:00"
    },
    {
      "id": 163439,
      "address": "498 Cannon Street",
      "numberOfPeople": 72,
      "cost": 55.255,
      "title": "Prof.",
      "message": "R42k1YATwO",
      "issuer": "PhFebB3pao",
      "time": "2023-03-19T08:17:12.000+00:00"
    },
    {
      "id": 937882,
      "address": "498 Cannon Street",
      "numberOfPeople": 72,
      "cost": 55.255,
      "title": "Prof.",
      "message": "R42k1YATwO",
      "issuer": "PhFebB3pao",
      "time": "2023-03-19T08:17:12.000+00:00"
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[JSONObject](#schemajsonobject)|

## DELETE 删除演出

DELETE /play/delete/

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "message": "success"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[JSONObject](#schemajsonobject)|

## PUT 添加演出

PUT /play/add/

> Body 请求参数

```json
{
  "id": 764777,
  "address": "498 Cannon Street",
  "numberOfPeople": 72,
  "cost": 55.255,
  "title": "Prof.",
  "message": "R42k1YATwO",
  "issuer": "PhFebB3pao",
  "time": "2023-03-19T08:17:12.000+00:00"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[Play](#schemaplay)| 否 |none|

> 返回示例

> 成功

```json
{
  "message": "success"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[JSONObject](#schemajsonobject)|

# 数据模型

<h2 id="tocS_JSONObject">JSONObject</h2>

<a id="schemajsonobject"></a>
<a id="schema_JSONObject"></a>
<a id="tocSjsonobject"></a>
<a id="tocsjsonobject"></a>

```json
{
  "key": {}
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|key|object|false|none||none|

<h2 id="tocS_Play">Play</h2>

<a id="schemaplay"></a>
<a id="schema_Play"></a>
<a id="tocSplay"></a>
<a id="tocsplay"></a>

```json
{
  "id": 0,
  "address": "string",
  "numberOfPeople": 0,
  "cost": 0,
  "title": "string",
  "message": "string",
  "issuer": "string",
  "time": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|false|none||none|
|address|string|false|none||地址|
|numberOfPeople|integer|false|none||人数|
|cost|number|false|none||费用/每人|
|title|string|false|none||演出标题|
|message|string|false|none||演出信息|
|issuer|string|false|none||发行方|
|time|string|false|none||演出时间|

