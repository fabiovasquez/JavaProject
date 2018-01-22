<%@ include file="../Shared/_headerPartial.jsp" %>
<%@ include file="../Shared/_menuPartial.jsp" %>

<div class="col-lg-12">
    <!--state overview start-->
    <div class="row state-overview">
        <div class="col-lg-3 col-sm-6">
            <section class="panel">
                <div class="symbol yellow" style="background:#f7a800">
                    <i class="fa fa-mail-forward"></i>
                </div>
                <div class="value">
                    <h1 class="countSent">5209</h1>
                    <p>Todas</p>
                </div>
            </section>
        </div>
        <div class="col-lg-3 col-sm-6">
            <section class="panel">
                <div class="symbol blue" style="background: #A9C4D5;">
                    <i class="fa fa-clock-o"></i>
                </div>
                <div class="value">
                    <h1 class=" count2">150</h1>
                    <p>Em aprovação</p>
                </div>
            </section>
        </div>
        <div class="col-lg-3 col-sm-6">
            <section class="panel">
                <div class="symbol terques" style="background: #00476a;">
                    <i class="fa fa-thumbs-up"></i>
                </div>
                <div class="value">
                    <h1 class=" count3">2302</h1>
                    <p>Aprovadas</p>
                </div>
            </section>
        </div>
        <div class="col-lg-3 col-sm-6">
            <section class="panel">
                <div class="symbol red" style="background: #dd3154;">
                    <i class="fa fa-thumbs-down"></i>
                </div>
                <div class="value">
                    <h1 class=" count4">33</h1>
                    <p>Rejeitadas</p>
                </div>
            </section>
        </div>
    </div>
</div>
<!--state overview end-->

<div class="col-lg-12">
    <section class="panel">
        <header class="panel-heading">
            <h3 style="font-size:18px;">
                <a data-toggle="collapse" href="#collapseChart"><i class="fa fa-line-chart"></i>&nbsp;&nbsp; Invoices enviadas mês a mês</a>
            </h3>
        </header>
        <div id="collapseChart" class="panel-body collapse">

            <!--custom chart end-->
        </div>
    </section>
</div>

</body>
</html>