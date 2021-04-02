<!DOCTYPE HTML>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <html>

    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Catamaran:wght@800&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Lato:wght@300;700&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Lato:wght@300;700&family=Roboto+Mono&display=swap"
            rel="stylesheet">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/html/ReviewPages/styling/masterStyling.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/html/ReviewPages/styling/reviewsStyling.css">
    </head>

    <body>
        <nav class="navbar navbar-expand-sm bg-primary navbar-dark">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/index.html">White Sands National Park</a>
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}/html/ReviewPages/insert.jsp">Add Review</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="${pageContext.request.contextPath}/ReviewList">Display Reviews</a>
                </li>
            </ul>
        </nav>

        <div class="containter">
            <div class="row banner">
                <div class="col banner-text">
                    See what <br> people are saying
                </div>
            </div>

            <div class="row divider"></div>

            <div class="row filter-text left-col">Choose from the filtering options below</div>
	            <div class="row divider"></div>
	            <div class="row">
	                <div class="col left-col">
	                	<form name="displayRview" action="${pageContext.request.contextPath}/ReviewList" method="post">
		                    <div class="row">
		                        <input type="submit" name="action" value="Search by Rating:" class="btn btn-primary" />
		                        <select name="rating" class="form-control" id="sel1">
		                            <option value="1">1</option>
		                            <option value="2">2</option>
		                            <option value="3">3</option>
		                            <option value="4">4</option>
		                            <option value="5">5</option>
		                        </select>
		                    </div>
		
		                    <div class="row divider"></div>
		
		                    <div class="row">
		                        <input type="submit" name="action" value="Search by Recommendation:" class="btn btn-primary" />
		                        <input type="radio" name="recommendation" id="wouldRecommend" checked value="1">
		                        <label class="radio-inline">Yes</label>
		
		                        <input type="radio" name="recommendation" id="wouldNotRecommend" value="2">
		                        <label class="radio-inline">No</label>
		                    </div>
		
		                    <div class="row divider"></div>
		
		                    <div class="row">
		                        <input type="text" class="form-control" name="fullName" id="firstName"
		                            placeholder="Enter full name...">
		                        <input type="submit" name="action" value="Search by Full Name:" class="btn btn-primary" />
		                    </div>
		                </form>
	                </div>
	            

	                <div class="col right-col">
	                    <img class="park-map" src="${pageContext.request.contextPath}/html/ReviewPages/images/park_map.jpg">
	                </div>   
	            </div>

            <div class="row divider"></div>

            <div class="row left-col right-col">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Name</th>
                            <th scope="col">Title</th>
                            <th scope="col">Rating</th>
                            <th scope="col">Review</th>
                        </tr>
                    </thead>
            
                    <tbody>
                        <c:forEach var="review" items="${reviews}">
                            <tr>
                                <td>
                                    <c:out value="${review.userName}" />
                                </td>
                                <td>
                                    <c:out value="${review.reviewTitle}" />
                                </td>
                                <td>
                                    <c:out value="${review.rating}" />
                                </td>
                                <td>
                                    <c:out value="${review.reviewBody}" />
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>


        <div class="row divider"></div>
        <div class="row divider"></div>
        <div class="row divider"></div>

        <div class="footer">
            <a href="https://www.nps.gov/whsa/index.htm">National Park Service Website</a> |
            Made with ❤️ by Dude, Where's My Char?
        </div>
    </body>
    
    </html>