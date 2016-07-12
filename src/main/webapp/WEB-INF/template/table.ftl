	<a href="user_modify">添加</a>
<table >
<#list userList as user>
	<tr>
		<td>${user.userName}</td>
		<td>${user.password}</td>
		<td>${user.realName}</td>
		<td>${user.phoneNum}</td>
		<td><a href = "user_modify?userId=${user.id}">修改</a>
			<a href = "delete?userId=${user.id}">删除</a>
		</td>
	</tr>
</#list>
</table>