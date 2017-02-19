<h1>Error Page</h1>
<p>Application has encountered an error</p>

<p>Failed URL: ${url}</p>
<p>Exception:  ${exception.message}</p>
<c:forEach items="${exception.stackTrace}" var="ste">
    ${ste}<br />
</c:forEach>

