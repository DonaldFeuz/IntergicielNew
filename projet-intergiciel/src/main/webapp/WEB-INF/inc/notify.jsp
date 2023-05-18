<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap-notify.min.js"></script>

<script>
    // Form error message
    <c:if test="${ !empty errors }">
        $.notify({
            title: '<strong>Erreur:</strong>',
            message: 'Verifié les données de votre formulaire'
        },{
            type: 'danger',
            newest_on_top: true
        });
    </c:if>

    // Info message
    <c:if test="${ !empty info }">
        $.notify({
            title: '<strong>Info:</strong>',
            message: '${ info }'
        },{
            type: 'info',
            newest_on_top: true
        });
    </c:if>

    // Success message
    <c:if test="${ !empty success }">
        $.notify({
            title: '<strong>Succès:</strong>',
            message: '${ success }'
        },{
            type: 'success',
            newest_on_top: true
        });
    </c:if>
    
    // Waning message
    <c:if test="${ !empty warning }">
        $.notify({
            title: '<strong>Attention:</strong>',
            message: '${ warning }'
        },{
            type: 'warning',
            newest_on_top: true
        });
    </c:if>
    
 	// Waning message 1
    <c:if test="${ !empty param.warning && param.warning eq '1' }">
        $.notify({
            title: '<strong>Attention: Vous devez vous connecter avant toute action !</strong>',
            message: '${ reqWarning }'
        },{
            type: 'warning',
            newest_on_top: true
        });
    </c:if>
    
 	// Waning message 2
    <c:if test="${ !empty param.warning && param.warning eq '2' }">
        $.notify({
            title: "<strong>Attention: Vous n'avez pas accès à cette page !</strong>",
            message: '${ reqWarning }'
        },{
            type: 'warning',
            newest_on_top: true
        });
    </c:if>
    
    // Error message 
    <c:if test="${ !empty error }">
        $.notify({
            title: '<strong>Erreur:</strong>',
            message: '${ error }'
        },{
            type: 'danger',
            newest_on_top: true
        });
    </c:if>

</script>