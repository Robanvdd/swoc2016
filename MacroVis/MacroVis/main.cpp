#include <QGuiApplication>
#include <QQmlApplicationEngine>
#include <QQmlContext>
#include <QApplication>

#include "fileio.h"
#include "customfiledialog.h"
#include "game.h"
#include "solarsystem.h"
#include "planet.h"
#include "planetimageprovider.h"
#include "player.h"
#include "ufo.h"

int main(int argc, char *argv[])
{
    QCoreApplication::setAttribute(Qt::AA_EnableHighDpiScaling);
    QApplication app(argc, argv);

    PlanetImageProvider planetImageProvider;

    qmlRegisterType<FileIO>("SWOC", 1, 0, "FileIO");
    qmlRegisterType<CustomFileDialog>("SWOC", 1, 0, "CustomFileDialog");
    qmlRegisterType<Game>("SWOC", 1, 0, "Game");
    qmlRegisterType<SolarSystem>("SWOC", 1, 0, "SolarSystem");
    qmlRegisterType<Planet>("SWOC", 1, 0, "Planet");
    qmlRegisterType<Player>("SWOC", 1, 0, "Player");
    qmlRegisterType<Ufo>("SWOC", 1, 0, "Ufo");

    QQmlApplicationEngine engine;
    QQmlContext* context = engine.rootContext();
    context->setContextProperty("planetImageProvider", &planetImageProvider);

    engine.load(QUrl(QLatin1String("qrc:/Qml/"
                                   "main.qml")));

    return app.exec();
}