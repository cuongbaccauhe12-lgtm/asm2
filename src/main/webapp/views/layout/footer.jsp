</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<nav class="mt-3">
    <ul class="pagination">
        <c:forEach begin="1" end="${totalPages}" var="i">
            <li class="page-item ${i == page ? 'active' : ''}">
                <a class="page-link"
                   href="${pageContext.request.contextPath}/khach-hang?page=${i}&keyword=${keyword}">
                        ${i}
                </a>
            </li>
        </c:forEach>
    </ul>
</nav>
</body>
</html>