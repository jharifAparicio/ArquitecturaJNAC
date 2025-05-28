<?php

namespace App\Filament\Resources;

use App\Filament\Resources\HabitacionResource\Pages;
use App\Filament\Resources\HabitacionResource\RelationManagers;
use App\Models\Habitacion;
use Filament\Forms;
use Filament\Forms\Components\Select;
use Filament\Forms\Components\TextInput;
use Filament\Forms\Form;
use Filament\Resources\Resource;
use Filament\Tables;
use Filament\Tables\Columns\TextColumn;
use Filament\Tables\Table;
use Illuminate\Database\Eloquent\Builder;
use Illuminate\Database\Eloquent\SoftDeletingScope;

class HabitacionResource extends Resource
{
    protected static ?string $model = Habitacion::class;

    protected static ?string $navigationIcon = 'heroicon-o-rectangle-stack';

    public static function form(Form $form): Form
    {
        return $form
            ->schema([
                //
                TextInput::make('numero_habitacion')
                    ->required()
                    ->maxLength(255),
                Select::make('tipo_habitacion_id')
                    ->label('Tipo de Habitacion')
                    ->relationship('tipoDeHabitacion', 'nombre')
                    ->required(),
                TextInput::make('precio_por_noche')
                    ->required()
                    ->numeric()
                    ->minValue(0)
                    ->maxValue(1000000)
                    ->default(0),
                Select::make('estado')
                    ->options([
                        'disponible' => 'Disponible',
                        'ocupada' => 'Ocupada',
                        'mantenimiento' => 'En Mantenimiento',
                    ])
                    ->default('disponible')
                    ->required(),
                TextInput::make('descripcion')
                    ->maxLength(500)
                    ->nullable(),
            ]);
    }

    public static function table(Table $table): Table
    {
        return $table
            ->columns([
                TextColumn::make('numero_habitacion')
                    ->label('Número de Habitación')
                    ->sortable()
                    ->searchable(),
                TextColumn::make('tipoDeHabitacion.nombre')
                    ->label('Tipo de Habitación')
                    ->sortable(),
                TextColumn::make('precio_por_noche')
                    ->label('Precio por Noche')
                    ->sortable()
                    ->searchable()
                    ->formatStateUsing(fn($state) => '$' . number_format($state, 2)),
                TextColumn::make('estado')
                    ->label('Estado')
                    ->sortable()
                    ->searchable(),
                TextColumn::make('descripcion')
                    ->label('Descripción')
                    ->limit(50)
                    ->sortable()
                    ->searchable(),
            ])
            ->filters([
                //
            ])
            ->actions([
                Tables\Actions\EditAction::make(),
            ])
            ->bulkActions([
                Tables\Actions\BulkActionGroup::make([
                    Tables\Actions\DeleteBulkAction::make(),
                ]),
            ]);
    }

    public static function getRelations(): array
    {
        return [
            //
        ];
    }

    public static function getPages(): array
    {
        return [
            'index' => Pages\ListHabitacions::route('/'),
            'create' => Pages\CreateHabitacion::route('/create'),
            'edit' => Pages\EditHabitacion::route('/{record}/edit'),
        ];
    }
}
