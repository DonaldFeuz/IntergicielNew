<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="https://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Liste des Transactions</title>

    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
</head>

<body>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="main-box clearfix">
                    <h2 style="text-align: center;">LISTE DES TRANSACTIONS</h2>
                    <div class="table-responsive">${transactions}
                        <table class="table user-list" style="margin-left: 100px;">
                            <thead>
                                <tr>
                                    <th><span>Emetteur</span></th>
                                    <th><span>Recepteur</span></th>
                                    <th><span>Montant</span></th>
                                    <th><span>Devise</span></th>
                                    <th><span>Created</span></th>
                                    <th>&nbsp; <span>Action</span></th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>
                                        <img src="https://bootdey.com/img/Content/avatar/avatar1.png" alt="">
                                        <a href="#" class="user-link">Mila Kunis</a>
                                    </td>
                                    <td>
                                        <img src="https://bootdey.com/img/Content/avatar/avatar2.png" alt="">
                                        <a href="#" class="user-link">Boris</a>
                                    </td>
                                    <td>5000</td>
                                    <td>
                                        FCFA
                                    </td>
                                    <td>
                                        <a href="#">23/05/26</a>
                                    </td>
                                    <td style="width: 20%;">
                                        <a href="#" class="table-link">
                                            <span class="fa-stack">
                                                <i class="fa fa-square fa-stack-2x"></i>
                                                <i class="fa fa-search-plus fa-stack-1x fa-inverse"></i>
                                            </span>
                                        </a>
                                        <a href="#" class="table-link">
                                            <span class="fa-stack">
                                                <i class="fa fa-square fa-stack-2x"></i>
                                                <i class="fa fa-pencil fa-stack-1x fa-inverse"></i>
                                            </span>
                                        </a>
                                        <a href="#" class="table-link danger">
                                            <span class="fa-stack">
                                                <i class="fa fa-square fa-stack-2x"></i>
                                                <i class="fa fa-trash-o fa-stack-1x fa-inverse"></i>
                                            </span>
                                        </a>
                                    </td>
                                </tr>
                               
                                
                                <tr>
                                    <td>
                                        <img src="https://bootdey.com/img/Content/avatar/avatar6.png" alt="">
                                        <a href="#" class="user-link">Robert Downey Jr.</a>
                                        <span class="user-subhead">Admin</span>
                                    </td>
                                    <td>
                                        2013/12/31
                                    </td>
                                    <td class="text-center">
                                        <span class="label label-success">Active</span>
                                    </td>
                                    <td>
                                        <a href="#">spencer@tracy</a>
                                    </td>
                                    <td style="width: 20%;">
                                        <a href="#" class="table-link">
                                            <span class="fa-stack">
                                                <i class="fa fa-square fa-stack-2x"></i>
                                                <i class="fa fa-search-plus fa-stack-1x fa-inverse"></i>
                                            </span>
                                        </a>
                                        <a href="#" class="table-link">
                                            <span class="fa-stack">
                                                <i class="fa fa-square fa-stack-2x"></i>
                                                <i class="fa fa-pencil fa-stack-1x fa-inverse"></i>
                                            </span>
                                        </a>
                                        <a href="#" class="table-link danger">
                                            <span class="fa-stack">
                                                <i class="fa fa-square fa-stack-2x"></i>
                                                <i class="fa fa-trash-o fa-stack-1x fa-inverse"></i>
                                            </span>
                                        </a>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>


<style>
    body {
        margin-top: 20px;
    }


    /* USER LIST TABLE */
    .user-list tbody td>img {
        position: relative;
        max-width: 50px;
        float: left;
        margin-right: 50px;
    }

    .user-list tbody td .user-link {
        display: block;
        font-size: 1.25em;
        padding-top: 3px;
        margin-left: 150px;
    }

    .user-list tbody td .user-subhead {
        font-size: 0.875em;
        font-style: italic;
    }

    /* TABLES */
    .table {
        border-collapse: separate;
    }

    .table-hover>tbody>tr:hover>td,
    .table-hover>tbody>tr:hover>th {
        background-color: #eee;
    }

    .table thead>tr>th {
        border-bottom: 1px solid #C2C2C2;
        padding-bottom: 0;
    }

    .table tbody>tr>td {
        font-size: 0.875em;
        background: #f5f5f5;
        border-top: 10px solid #fff;
        vertical-align: middle;
        padding: 12px 8px;
    }

    .table tbody>tr>td:first-child,
    .table thead>tr>th:first-child {
        padding-left: 20px;
    }

    .table thead>tr>th span {
        border-bottom: 2px solid #C2C2C2;
        display: inline-block;
        padding: 0 5px;
        padding-bottom: 5px;
        font-weight: normal;
    }

    .table thead>tr>th>a span {
        color: #344644;
    }

    .table thead>tr>th>a span:after {
        content: "\f0dc";
        font-family: FontAwesome;
        font-style: normal;
        font-weight: normal;
        text-decoration: inherit;
        margin-left: 5px;
        font-size: 0.75em;
    }

    .table thead>tr>th>a.asc span:after {
        content: "\f0dd";
    }

    .table thead>tr>th>a.desc span:after {
        content: "\f0de";
    }

    .table thead>tr>th>a:hover span {
        text-decoration: none;
        color: #2bb6a3;
        border-color: #2bb6a3;
    }

    .table.table-hover tbody>tr>td {
        -webkit-transition: background-color 0.15s ease-in-out 0s;
        transition: background-color 0.15s ease-in-out 0s;
    }

    .table tbody tr td .call-type {
        display: block;
        font-size: 0.75em;
        text-align: center;
    }

    .table tbody tr td .first-line {
        line-height: 1.5;
        font-weight: 400;
        font-size: 1.125em;
    }

    .table tbody tr td .first-line span {
        font-size: 0.875em;
        color: #969696;
        font-weight: 300;
    }

    .table tbody tr td .second-line {
        font-size: 0.875em;
        line-height: 1.2;
    }

    .table a.table-link {
        margin: 0 5px;
        font-size: 1.125em;
    }

    .table a.table-link:hover {
        text-decoration: none;
        color: #2aa493;
    }

    .table a.table-link.danger {
        color: #fe635f;
    }

    .table a.table-link.danger:hover {
        color: #dd504c;
    }

    .table-products tbody>tr>td {
        background: none;
        border: none;
        border-bottom: 1px solid #ebebeb;
        -webkit-transition: background-color 0.15s ease-in-out 0s;
        transition: background-color 0.15s ease-in-out 0s;
        position: relative;
    }

    .table-products tbody>tr:hover>td {
        text-decoration: none;
        background-color: #f6f6f6;
    }

    .table-products .name {
        display: block;
        font-weight: 600;
        padding-bottom: 7px;
    }

    .table-products .price {
        display: block;
        text-decoration: none;
        width: 50%;
        float: left;
        font-size: 0.875em;
    }

    .table-products .price>i {
        color: #8dc859;
    }

    .table-products .warranty {
        display: block;
        text-decoration: none;
        width: 50%;
        float: left;
        font-size: 0.875em;
    }

    .table-products .warranty>i {
        color: #f1c40f;
    }

    .table tbody>tr.table-line-fb>td {
        background-color: #9daccb;
        color: #262525;
    }

    .table tbody>tr.table-line-twitter>td {
        background-color: #9fccff;
        color: #262525;
    }

    .table tbody>tr.table-line-plus>td {
        background-color: #eea59c;
        color: #262525;
    }

    .table-stats .status-social-icon {
        font-size: 1.9em;
        vertical-align: bottom;
    }

    .table-stats .table-line-fb .status-social-icon {
        color: #556484;
    }

    .table-stats .table-line-twitter .status-social-icon {
        color: #5885b8;
    }

    .table-stats .table-line-plus .status-social-icon {
        color: #a75d54;
    }
</style>

</html>