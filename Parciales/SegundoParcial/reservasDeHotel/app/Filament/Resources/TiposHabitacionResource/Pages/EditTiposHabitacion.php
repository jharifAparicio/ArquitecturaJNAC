<?php

namespace App\Filament\Resources\TiposHabitacionResource\Pages;

use App\Filament\Resources\TiposHabitacionResource;
use Filament\Actions;
use Filament\Resources\Pages\EditRecord;

class EditTiposHabitacion extends EditRecord
{
    protected static string $resource = TiposHabitacionResource::class;

    protected function getHeaderActions(): array
    {
        return [
            Actions\DeleteAction::make(),
        ];
    }
}
