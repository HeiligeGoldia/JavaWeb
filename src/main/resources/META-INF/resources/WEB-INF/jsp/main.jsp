<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Pro Vip Shop</title>
	<link href="/resources/css/style.css" rel="stylesheet">
	<link
		href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
		rel="stylesheet">
</head>

<body>
	<header>
		<div class="container-fluid">
			<div
				class="row align-items-center bg-light py-3 px-xl-5 d-none d-lg-flex">
				<div class="col-lg-4">
					<a href="/" class="text-decoration-none"> <span
						class="h1 text-uppercase text-primary bg-dark px-2">ProVip</span>
						<span class="h1 text-uppercase text-dark bg-primary px-2 ml-n1">Shop</span>
					</a>
				</div>
				<div class="col-lg-4 col-6 text-left">
					<form action="">
						<div class="input-group">
							<input type="text" class="form-control"
								placeholder="Tìm Kiếm Sản Phẩm">
							<div class="input-group-append">
								<span class="input-group-text bg-transparent text-primary">
									<i class="fa fa-search"></i>
								</span>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>

		<div class="container-fluid bg-dark mb-30">
			<div class="row px-xl-5">
				<div class="col-lg-3 d-none d-lg-block">
					<a
						class="btn d-flex align-items-center justify-content-between bg-primary w-100"
						data-toggle="collapse" href="#navbar-vertical"
						style="height: 65px; padding: 0 30px;">
						<h6 class="text-dark m-0">
							<i class="fa fa-bars mr-2"></i>Phân Loại
						</h6> <i class="fa fa-angle-down text-dark"></i>
					</a>
					<nav
						class="collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 bg-light"
						id="navbar-vertical"
						style="width: calc(100% - 30px); z-index: 999;">
						<div class="navbar-nav w-100">
							<a href="" class="nav-item nav-link">Camera An Ninh</a> <a
								href="" class="nav-item nav-link">Thiết Bị Báo Cháy Và Báo
								Động</a> <a href="" class="nav-item nav-link">Thiết Bị Số Và
								Công Nghệ</a> <a href="" class="nav-item nav-link">Thiết Bị Kiểm
								Soát Cửa</a>
						</div>
					</nav>
				</div>
				<div class="col-lg-9">
					<nav
						class="navbar navbar-expand-lg bg-dark navbar-dark py-3 py-lg-0 px-0">
						<a href="" class="text-decoration-none d-block d-lg-none"> <span
							class="h1 text-uppercase text-dark bg-light px-2">PROVIP</span> <span
							class="h1 text-uppercase text-light bg-primary px-2 ml-n1">Shop</span>
						</a>
						<button type="button" class="navbar-toggler"
							data-toggle="collapse" data-target="#navbarCollapse">
							<span class="navbar-toggler-icon"></span>
						</button>
						<div class="collapse navbar-collapse justify-content-between"
							id="navbarCollapse">
							<div class="navbar-nav mr-auto py-0">
								<a href="#" class="nav-item nav-link active">Trang Chủ</a> <a
									href="#" class="nav-item nav-link">Thông Tin</a> <a href="#"
									class="nav-item nav-link">Liên Hệ</a>
							</div>
							<div class="navbar-nav ml-auto py-0 d-none d-lg-block">
								<a href="/userinfo/profile" class="btn px-0"> <i
									class="fas fa-user text-primary"></i>
								</a> <a href="/cart" class="btn px-0 ml-3"> <i
									class="fas fa-shopping-cart text-primary"></i> <span
									class="badge text-secondary border border-secondary rounded-circle"
									style="padding-bottom: 2px;"></span>
								</a>
							</div>
						</div>
					</nav>
				</div>
			</div>
		</div>
	</header>

	<!-- Breadcrumb Start -->
	<div class="container-fluid">
		<div class="row px-xl-5">
			<div class="col-12">
				<nav class="breadcrumb bg-light mb-30">
					<a class="breadcrumb-item text-dark" href="#">Home</a> <a
<%--						class="breadcrumb-item text-dark" href="#">Shop</a> <span--%>
<%--						class="breadcrumb-item active">Shop List</span>--%>
				</nav>
			</div>
		</div>
	</div>
	<!-- Breadcrumb End -->


	<!-- Shop Start -->
	<div class="container-fluid">
		<div class="row px-xl-5">
			<!-- Shop Sidebar Start -->
			<!-- Shop Product Start -->
			<div class="col-lg-12 col-md-12">
				<div class="row pb-3" >
					<div class="col-lg-3 col-md-6 col-sm-6 pb-1" th:each="tempItem : ${items}">
						<div class="product-item bg-light mb-4">
							<div class="product-img position-relative overflow-hidden">
								<img class="img-fluid w-100" th:src="@{'/getimage/'+${tempItem.photo}}" alt="" style="width: 200px; height: 350px">
								<div class="product-action">
									<a class="btn btn-outline-dark btn-square" href=""><i
										class="fa fa-shopping-cart"></i></a> <a
										class="btn btn-outline-dark btn-square" href=""><i
										class="far fa-heart"></i></a> <a
										class="btn btn-outline-dark btn-square" href=""><i
										class="fa fa-sync-alt"></i></a> <a
										class="btn btn-outline-dark btn-square" href=""><i
										class="fa fa-search"></i></a>
								</div>
							</div>
							<div class="text-center py-4">
								<a class="h6 text-decoration-none text-truncate" th:href="@{/product_detail(itemId=${tempItem.id})}" th:text="${tempItem.name}"></a>
								<div class="d-flex align-items-center justify-content-center mt-2" th:text="${tempItem.price}"></div>
								<div
									class="d-flex align-items-center justify-content-center mb-1">
									<small class="fa fa-star text-primary mr-1"></small> <small
										class="fa fa-star text-primary mr-1"></small> <small
										class="fa fa-star text-primary mr-1"></small> <small
										class="fa fa-star text-primary mr-1"></small> <small
										class="fa fa-star text-primary mr-1"></small> <small>(0)</small>
								</div>
							</div>
						</div>
					</div>

					<div class="col-12">
						<nav>
							<ul class="pagination justify-content-center">
								<li class="page-item disabled"><a class="page-link"
									href="#">Previous</a></li>
								<li class="page-item active"><a class="page-link" href="#">1</a></li>
								<li class="page-item"><a class="page-link" href="#">2</a></li>
								<li class="page-item"><a class="page-link" href="#">3</a></li>
								<li class="page-item"><a class="page-link" href="#">Next</a></li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
			<!-- Shop Product End -->
		</div>
	</div>
	<!-- Shop End -->
	<footer>
		<!-- Footer Start -->
		<div class="container-fluid bg-dark text-secondary mt-5 pt-5">
			<div class="row px-xl-12 pt-3">
				<div class="col-lg-5 col-md-12 mb-5 pr-3 pr-xl-5">
					<h5 class="text-secondary text-uppercase mb-4">Liên Hệ Với
						Chúng Tôi</h5>
					<p class="mb-4">Thông tin liên lạc và địa chỉ của cửa hàng.</p>
					<p class="mb-2">
						<i class="fa fa-map-marker-alt text-primary mr-3"></i>129 Nguyễn Văn Bảo
					</p>
					<p class="mb-2">
						<i class="fa fa-envelope text-primary mr-3"></i>provip@gmail.com
					</p>
					<p class="mb-0">
						<i class="fa fa-phone-alt text-primary mr-3"></i>0829492559
					</p>
				</div>
				<div class="col-lg-7 col-md-8">
					<div class="row">
						<div class="col-md-5 mb-8">
							<h5 class="text-secondary text-uppercase mb-4">Liên Kết
								Nhanh</h5>
							<div class="d-flex flex-column justify-content-start">
								<a class="text-secondary mb-2" href="#"><i
									class="fa fa-angle-right mr-2"></i>Trang Chủ</a> <a
									class="text-secondary mb-2" href="#"><i
									class="fa fa-angle-right mr-2"></i>Thông Tin</a> <a
									class="text-secondary mb-2" href="#"><i
									class="fa fa-angle-right mr-2"></i>Giỏ Hàng</a> <a
									class="text-secondary mb-2" href="#"><i
									class="fa fa-angle-right mr-2"></i>Thanh Toán</a> <a
									class="text-secondary" href="#"><i
									class="fa fa-angle-right mr-2"></i>Liên Hệ</a>
							</div>
						</div>

						<div class="col-md-7 mb-4">
							<h5 class="text-secondary text-uppercase mb-4">Đăng Ký Nhận
								Thông Báo</h5>
							<p>Mua hàng online với nhiều ưu đãi hơn tại tập đoàn ProVip</p>
							<form action="">
								<div class="input-group">
									<input type="text" class="form-control"
										placeholder="Nhập email của bạn">
									<div class="input-group-append">
										<button class="btn btn-primary">Đăng Ký</button>
									</div>
								</div>
							</form>
							<h6 class="text-secondary text-uppercase mt-4 mb-3">Theo Dõi
								Chúng Tôi</h6>
							<div class="d-flex">
								<a class="btn btn-primary btn-square mr-2" href="#"><i
									class="fab fa-twitter"></i></a> <a
									class="btn btn-primary btn-square mr-2" href="#"><i
									class="fab fa-facebook-f"></i></a> <a
									class="btn btn-primary btn-square mr-2" href="#"><i
									class="fab fa-linkedin-in"></i></a> <a
									class="btn btn-primary btn-square" href="#"><i
									class="fab fa-instagram"></i></a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row border-top mx-xl-5 py-4"
				style="border-color: rgba(256, 256, 256, .1) !important;">
				<div class="col-md-6 px-xl-0">
					<p>Nhóm 6 (ProVip Sunglasses Shop)</p>
				</div>
				<div class="col-md-6 px-xl-0 text-center text-md-right">
					<img class="img-fluid" src="img/payments.png" alt="">
				</div>
			</div>
		</div>
		<!-- Footer End -->

	</footer>
	<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
	<script src="lib/easing/easing.min.js"></script>
	<script src="lib/owlcarousel/owl.carousel.min.js"></script>


</body>

</html>