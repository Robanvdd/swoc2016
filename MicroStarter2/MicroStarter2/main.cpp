#include <QGuiApplication>
#include <QQmlApplicationEngine>
#include <QQmlContext>
#include "fileio.h"
#include "process.h"

int main(int argc, char *argv[])
{
    QCoreApplication::setAttribute(Qt::AA_EnableHighDpiScaling);
    QGuiApplication app(argc, argv);

    QQmlApplicationEngine engine;
    qmlRegisterType<FileIO>("SWOC", 1, 0, "FileIO");
    qmlRegisterType<Process>("SWOC", 1, 0, "Process");
    engine.rootContext()->setContextProperty("applicationDirPath", QGuiApplication::applicationDirPath());

    engine.load(QUrl(QLatin1String("qrc:/main.qml")));
    if (engine.rootObjects().isEmpty())
        return -1;

    return app.exec();
}