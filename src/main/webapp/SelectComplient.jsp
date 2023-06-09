<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


        <!DOCTYPE html>
        <html lang="en">

        <head>

            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
            <meta name="description" content="">
            <meta name="author" content="">

            <title>SB Admin 2 - Tables</title>

            <!-- Custom fonts for this template -->
            <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
            <link
                href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
                rel="stylesheet">

            <!-- Custom styles for this template -->
            <link href="css/sb-admin-2.min.css" rel="stylesheet">

            <!-- Custom styles for this page -->
            <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

        </head>

        <body id="page-top">

            <!-- Page Wrapper -->
            <div id="wrapper">

                <jsp:include page="sidebar.html" />
                <!-- Content Wrapper -->
                <div id="content-wrapper" class="d-flex flex-column">

                    <!-- Main Content -->
                    <div id="content">

                        <!-- Topbar -->
                        <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                            <!-- Sidebar Toggle (Topbar) -->
                            <form class="form-inline">
                                <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                                    <i class="fa fa-bars"></i>
                                </button>
                            </form>

                            <!-- Topbar Search -->
                            <form
                                class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search"
                                action="GetComplientsByID">
                                抱怨序號 :<br> <input type="text" name="username" /> <input type="submit" value="確定" />
                            </form>


                            <form
                                class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search"
                                action="GetComplientsByName">
                                姓名 :<br> <input type="text" name="name" /> <input type="submit" value="確定" />
                            </form>

                            <form
                                class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search" action="GetComplientsByType">
                                提問類型 : <br> <select name="complaintID">
                                    <option value="member">帳戶問題</option>
                                    <option value="purchase">購買問題</option>
                                    <option value="order">訂單問題</option>
                                    <option value="service">服務問題</option>
                                    <option value="dispute">消費爭議</option>
                                    <option value="forum">論壇問題</option>
                                    <option value="other">其他</option>
                                </select> <input type="submit" value="確定" />
                            </form>


                            <!-- Topbar Navbar -->


                            <!-- Nav Item - Alerts -->
                            <li class="nav-item dropdown no-arrow mx-1">
                                <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fas fa-bell fa-fw"></i>
                                    <!-- Counter - Alerts -->

                                </a>
                                <!-- Dropdown - Alerts -->
                                <!-- <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="alertsDropdown">
                                <h6 class="dropdown-header">
                                    Alerts Center
                                </h6>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="mr-3">
                                        <div class="icon-circle bg-primary">
                                            <i class="fas fa-file-alt text-white"></i>
                                        </div>
                                    </div>
                                    <div>
                                        <div class="small text-gray-500">December 12, 2019</div>
                                        <span class="font-weight-bold">A new monthly report is ready to download!</span>
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="mr-3">
                                        <div class="icon-circle bg-success">
                                            <i class="fas fa-donate text-white"></i>
                                        </div>
                                    </div>
                                    <div>
                                        <div class="small text-gray-500">December 7, 2019</div>
                                        $290.29 has been deposited into your account!
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="mr-3">
                                        <div class="icon-circle bg-warning">
                                            <i class="fas fa-exclamation-triangle text-white"></i>
                                        </div>
                                    </div>
                                    <div>
                                        <div class="small text-gray-500">December 2, 2019</div>
                                        Spending Alert: We've noticed unusually high spending for your account.
                                    </div>
                                </a>
                                <a class="dropdown-item text-center small text-gray-500" href="#">Show All Alerts</a>
                            </div> -->
                            </li>

                            <!-- Nav Item - Messages -->
                            <!-- <li class="nav-item dropdown no-arrow mx-1">
                            <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-envelope fa-fw"></i>
                                Counter - Messages -->
                            <!-- <span class="badge badge-danger badge-counter">7</span>
                            </a> -->
                            <!-- Dropdown - Messages -->
                            <!-- </li> -->

                            <div class="topbar-divider d-none d-sm-block"></div>

                            <!-- Nav Item - User Information -->

                            </ul>

                        </nav>
                        <!-- End of Topbar -->

                        <!-- Begin Page Content -->
                        <div class="container-fluid">

                            <!-- Page Heading -->
                            <h1 class="h3 mb-2 text-gray-800">客服表格</h1>

                            <!-- DataTales Example -->
                            <div class="card shadow mb-4">
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">

                                            <thead>
                                                <tr>
                                                    <td>提問日期</td>
                                                    <td>姓名</td>
                                                    <td>信箱</td>
                                                    <td>提問類型</td>
                                                    <td>標題</td>
                                                    <td>提問內容</td>
                                                    <td>查看</td>
                                                    <td>回信</td>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${Complients}" var="c">
                                                    <tr>
                                                        <td>${c.createDate}</td>
                                                        <td>${c.customerName}</td>
                                                        <td>${c.email}</td>
                                                        <td>${c.complaintID}</td>
                                                        <td>${c.title}</td>
                                                        <td>${c.content}</td>
                                                        <td><a
                                                                href="ViewComplient.jsp?name=${c.customerName}&email=${c.email}&complaintID=${c.complaintID}&title=${c.title}&content=${c.content}"><button>查看</button></a>
                                                        </td>
                                                        <td><a
                                                                href="ApplyComplients.jsp?ApplyDate=${c.createDate}&customerID=${c.customerID}&name=${c.customerName}&email=${c.email}&complaintID=${c.complaintID}&title=${c.title}&content=${c.content}"><button>回信</button></a>
                                                        </td>

                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <!-- /.container-fluid -->

                    </div>
                    <!-- End of Main Content -->

                    <!-- Footer -->
                    <footer class="sticky-footer bg-white">
                        <div class="container my-auto">
                            <div class="copyright text-center my-auto">
                                <span>Copyright &copy; Your Website 2020</span>
                            </div>
                        </div>
                    </footer>
                    <!-- End of Footer -->

                </div>
                <!-- End of Content Wrapper -->

            </div>
            <!-- End of Page Wrapper -->

            <!-- Scroll to Top Button-->
            <a class="scroll-to-top rounded" href="#page-top">
                <i class="fas fa-angle-up"></i>
            </a>

            <!-- Logout Modal-->
            <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
                aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">×</span>
                            </button>
                        </div>
                        <div class="modal-body">Select "Logout" below if you are ready to end your current session.
                        </div>
                        <div class="modal-footer">
                            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                            <a class="btn btn-primary" href="login.html">Logout</a>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Bootstrap core JavaScript-->
            <script src="vendor/jquery/jquery.min.js"></script>
            <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

            <!-- Core plugin JavaScript-->
            <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

            <!-- Custom scripts for all pages-->
            <script src="js/sb-admin-2.min.js"></script>

            <!-- Page level plugins -->
            <script src="vendor/datatables/jquery.dataTables.min.js"></script>
            <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

            <!-- Page level custom scripts -->
            <script src="js/demo/datatables-demo.js"></script>

        </body>

        </html>