<#include "menu.ftl">
<#macro content>
    <#list chats as chat>

        <#if currentUser.id == chat.sender.id>
        <a href="/id${chat.sender.id}">
            <h4> ${chat.sender.firstName} ${chat.sender.lastName}</h4></a>
        <#else>
        <a href="/id${currentUser.id}">
            <h4>  ${currentUser.firstName} ${currentUser.lastName}</h4></a>
        </#if>
    <br>
    </#list>
</#macro>