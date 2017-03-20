<#include "menu.ftl">
<#macro content>
    <#list chats as chat>

        <#if userSession.id == chat.sender.id>

        <a href="/chat${chat.receiver.id}">
            <h4> ${chat.receiver.firstName} ${chat.receiver.lastName}</h4></a>

        <#else>

        <a href="/chat${chat.sender.id}">
            <h4>  ${chat.sender.firstName} ${chat.sender.lastName}</h4></a>

        </#if>
    <br>
    </#list>
</#macro>