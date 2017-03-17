<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>

<head>
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css"/>
</head>

<body>
<ul class="nav nav-tabs">
    <li class="active">
        <a href="/home">Profile</a>
    </li>
    <li><a href="/friends">Users</a></li>
    <li><a href="/all_chats">My chats</a></li>
</ul>
<@content></@content>
</body>
